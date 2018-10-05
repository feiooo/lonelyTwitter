/* Class Name: Tweet
 *
 * Version: Version 1.0
 *
 * Date : October 4, 2018
 *
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */


/**
 * Created by FeiYang on 04/10/18.
 */



package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Represents a Tweet
 *
 * @author FeiYang
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */
public abstract class Tweet {
    /**
     * The Message.
     */
    protected String message;
    /**
     * The Date.
     */
    protected Date date ;



    /**
     * Constructs Tweet objects
     *
     * @param message tweet message
     * @param date tweet date
     */


    /**
     * Sets tweet messages
     *
     * @param message Tweet message
     * @throws TooLongTweetException the too long tweet exception
     */
    public void setMessage(String message) throws TooLongTweetException{
        if(message.length()>140){
            throw new TooLongTweetException();
        }
        this.message = message;

    }


    /**
     * Set date.
     *
     * @param date the date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Get message string.
     *
     * @return the string
     */
    public String getMessage(){
        return this.message;
    }


    /**
     * Get date date.
     *
     * @return the date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    public String toString(){
        return this.date.toString()+" | "+this.message;
    }

    //public  setMood()
}

