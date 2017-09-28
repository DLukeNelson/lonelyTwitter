/*
 * NormalTweet
 *
 * Version 1.0
 *
 * September 27, 2017
 *
 * Copyright (c) 2017. dlnelson, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact dlnelson@ualberta.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Normal Tweet.
 *
 * @author dlnelson
 * @version 1.5
 * @see Tweet
 * @see Tweetable
 */
public class NormalTweet extends Tweet {
    /**
     * Constructs a normal tweet object.
     *
     * @param tweet tweet message
     * @param date tweet date
     * @throws TweetTooLongException for tweet > 140 characters
     */
    public NormalTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
    }

    /**
     * Constructs a normal tweet object (default date).
     *
     * @param tweet tweet message
     * @throws TweetTooLongException for tweet > 140 characters
     */
    public NormalTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    /**
     * Represents if tweet is important.
     *
     * @return false - tweet is not important.
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
