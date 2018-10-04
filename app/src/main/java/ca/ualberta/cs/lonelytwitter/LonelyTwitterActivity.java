/*
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import android.widget.Toast;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<String> showArray = new ArrayList<String>();
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	//String emotion = " ";
	String text;
	//String choice[] = {"Joy", "Surprise", "Sadness", "Anger"};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);
		//Spinner spin = (Spinner) findViewById(R.id.spinner);
		//spin.setOnItemClickListener(new OnItemSelectedListener);

		/**
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		//final ArrayList<String> list=new ArrayList<String>();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,choice);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				//Toast.makeText(LonelyTwitterActivity.this, "Mood: " + list.get(position), Toast.LENGTH_SHORT).show();
				emotion = choice[position];
			}

				public void onNothingSelected(AdapterView<?> parent) {
				}
		});

		//text = bodyText.getText().toString() + " / " + emotion;
*/
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//setResult(RESULT_OK);
				text = bodyText.getText().toString() ;//+ " / " + emotion;
				ImportantTweet newTweet = new ImportantTweet();

				try {
                    newTweet.setMessage(text);
                    newTweet.setDate(new Date());

                    showArray.add(text);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(LonelyTwitterActivity.this, android.R.layout.simple_list_item_1, showArray);
                    oldTweetsList.setAdapter(adapter);

                    //((EditText) findViewById(R.id.body)).setText(" ");


                    tweets.add(newTweet);
                    adapter.notifyDataSetChanged();
                    saveInFile();
                }
                catch(TooLongTweetException e){

                }
				//finish();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				tweets.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
		    FileInputStream fis = openFileInput(FILENAME);
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader reader = new BufferedReader(isr);

		    Gson gson = new Gson();
		    Type listTweetType = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
		    tweets = gson.fromJson(reader, listTweetType);



		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
		    FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(tweets,writer);
            writer.flush();
            fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}