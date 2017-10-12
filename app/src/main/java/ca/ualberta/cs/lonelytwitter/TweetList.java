package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by Luke on 2017-10-11.
 */

public class TweetList {

    private ArrayList<Tweet> tweets;

    public TweetList() {
        tweets = new ArrayList<Tweet>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }
}
