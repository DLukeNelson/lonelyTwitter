/*
 * Blissful
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
 * Represents the Blissful Mood.
 *
 * @author dlnelson
 * @version 1.5
 * @see Mood
 */
public class Blissful extends Mood {
    /**
     * Constructs a Blissful object (default date).
     */
    public Blissful() {
        super();
    }

    /**
     * Constructs a Blissful object.
     * @param date
     */
    public Blissful(Date date) {
        super(date);
    }

    /**
     * Represents the Blissful as a string.
     * @return String - representation of Blissful
     */
    public String stringRepresentation() {
        return "Blissful";
    }
}
