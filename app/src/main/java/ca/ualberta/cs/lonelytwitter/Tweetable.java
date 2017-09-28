/*
 * Tweetable
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
 * Represents a Tweetable interface
 *
 * @author dlnelson
 * @version 1.5
 * @see Tweet
 * @see NormalTweet
 * @see ImportantTweet
 */
public interface Tweetable {
    /**
     * Returns the tweetable object's text.
     * @return String - tweetable object's message.
     */
    String getText();

    /**
     * Returns the tweetable object's date.
     * @return Date - tweetable object's date.
     */
    Date getDate();

    /**
     * Adds a Mood to the tweetable object
     * @param mood Mood to add.
     */
    void addMood(Mood mood);

    /**
     * Details all the moods as a string.
     * @return String - represents tweetable object's moods.
     */
    String getMoodsString();
}
