/*
 * ImportantTweet
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
 * @author dlnelson
 * @version 1.5
 * @see Tweet
 * @see Tweetable
 */
public class ImportantTweet extends Tweet {
    /**
     * Constructs an Important Tweet object.
     *
     * @param tweet tweet message
     * @param date tweet date
     * @throws TweetTooLongException for tweet > 140 characters.
     */
    public ImportantTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    /**
     * Constructs an Important Tweet object (default date).
     *
     * @param tweet tweet message
     * @throws TweetTooLongException for tweet > 140 characters.
     */
    public ImportantTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    /**
     * Represents if this tweet is important.
     *
     * @return True - this tweet is important
     */
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    /**
     * Returns the tweet message.
     * @return String - tweet message.
     */
    @Override
    public String getText() {
        return "!!!" + super.getText();
    }

}
