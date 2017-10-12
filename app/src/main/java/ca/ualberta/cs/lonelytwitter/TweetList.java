package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Luke on 2017-10-11.
 */

public class TweetList {

    private ArrayList<Tweet> tweets;

    public TweetList() {
        tweets = new ArrayList<Tweet>();
    }

    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }
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

    public ArrayList<Tweet> getTweets() {
        ArrayList<Tweet> returnTweets =  new ArrayList<Tweet>();
        returnTweets.addAll(tweets);
        Collections.sort(returnTweets, new Comparator<Tweet>() {
                public int compare(Tweet t1, Tweet t2) {
                    return t1.getDate().compareTo(t2.getDate());
                }
            }
        );
        return returnTweets;
    }

    public int getCount() {
        return tweets.size();
    }

}
