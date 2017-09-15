package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by joshua2 on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;
    private List<Mood> moodList = new ArrayList<Mood>();

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Mood mood) {
        moodList.add(mood);
    }

    public String getMoodsString() {
        String s = "";
        for (Mood m: moodList) {
            s += m.stringRepresentation() + ", ";
        }
        //remove the trailing comma and space from last element.
        s = s.substring(0, s.length() - 2);
        return s;
    }

    public abstract Boolean isImportant();

}
