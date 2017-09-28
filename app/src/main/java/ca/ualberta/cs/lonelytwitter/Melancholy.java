/*
 * Melancholy
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
 * Represents the Melancholy Mood
 *
 * @author dlnelson
 * @version 1.5
 * @see Mood
 */
public class Melancholy extends Mood {
    /**
     * Constructs a Melancholy Mood object (default date).
     */
    public Melancholy() {
        super();
    }

    /**
     * Constructs a Melancholy Mood object.
     *
     * @param date Date of Melancholy.
     */
    public Melancholy(Date date) {
        super(date);
    }

    /**
     * Returns a string representation of Melancholy.
     *
     * @return String representing Melancholy.
     */
    public String stringRepresentation() {
        return "Melancholy";
    }
}
