/*
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 */



/**
 * Created by FeiYang on 04/10/18.
 */



package ca.ualberta.cs.lonelytwitter;

/**
 * The type Too long tweet exception.
 */
public class TooLongTweetException extends Exception {

    /**
     * Instantiates a new Too long tweet exception.
     */
    TooLongTweetException(){
        super("The message is too long! Please keep your tweets within 140 characters.");
    }

}
