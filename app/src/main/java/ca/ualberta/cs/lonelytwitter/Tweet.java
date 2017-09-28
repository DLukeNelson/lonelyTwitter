/*
 * Tweet
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a tweet.
 *
 * @author dlnelson
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @see Tweetable
 * @since 1.0
 */
public abstract class Tweet implements Tweetable {
    protected Date date;
    private String text;
    private List<Mood> moodList = new ArrayList<Mood>();

    /**
     * Constructs a Tweet object.
     *
     * @param tweet tweet message
     * @param date tweet date
     * @throws TweetTooLongException for tweet > 140 characters
     */
    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    /**
     * Constructs a tweet object (default date).
     *
     * @param tweet tweet message
     * @throws TweetTooLongException for tweet > 140 characters
     */
    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    /**
     * Returns the tweet message.
     *
     * @return the tweet message.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets a tweet message.
     *
     * @param text tweet message
     * @throws TweetTooLongException for tweet > 140 characters
     */
    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Returns the tweet date.
     *
     * @return tweet date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the tweet date.
     *
     * @param date tweet date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Adds a mood to tweet.
     *
     * @param mood mood to add
     */
    public void addMood(Mood mood) {
        moodList.add(mood);
    }

    /**
     * Displays all moods.
     *
     * @return string detailing all moods.
     */
    public String getMoodsString() {
        String s = "";
        for (Mood m: moodList) {
            s += m.stringRepresentation() + ", ";
        }
        //remove the trailing comma and space from last element.
        s = s.substring(0, s.length() - 2);
        return s;
    }

    /**
     * Represents if tweet is important
     * @return Boolean true if tweet is important.
     */
    public abstract Boolean isImportant();

    /**
     * Represents the tweet as a string
     * @return string representation of tweet object.
     */
    @Override
    public String toString() {
        return date.toString() + " | " + text;
    }

}
