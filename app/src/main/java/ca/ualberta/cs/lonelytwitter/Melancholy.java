package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Luke on 2017-09-13.
 */

public class Melancholy extends Mood {
    public Melancholy() {
        super();
    }

    public Melancholy(Date date) {
        super(date);
    }

    public String stringRepresentation() {
        return "Melancholy";
    }
}
