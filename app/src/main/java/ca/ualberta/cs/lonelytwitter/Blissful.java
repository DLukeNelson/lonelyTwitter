package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Luke on 2017-09-13.
 */

public class Blissful extends Mood {
    public Blissful() {
        super();
    }

    public Blissful(Date date) {
        super(date);
    }

    public String stringRepresentation() {
        return "Blissful";
    }
}
