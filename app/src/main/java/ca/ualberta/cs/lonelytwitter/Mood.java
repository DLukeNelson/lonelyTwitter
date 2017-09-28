/*
 * Mood
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
 * Represents a Mood
 *
 * @author dlnelson
 * @version 1.5
 * @see Blissful
 * @see Melancholy
 */
public abstract class Mood {
    private Date date;

    /**
     * Constructs a Mood object (default date).
     */
    public Mood() {
        this(new Date());
    }

    /**
     * Constructs a Mood object.
     *
     * @param date Date of mood
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Returns the date of Mood.
     *
     * @return Date of Mood.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets the date of Mood.
     *
     * @param date Date of mood.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * String representation of Mood.
     * @return String representation of Mood.
     */
    public abstract String stringRepresentation();
}
