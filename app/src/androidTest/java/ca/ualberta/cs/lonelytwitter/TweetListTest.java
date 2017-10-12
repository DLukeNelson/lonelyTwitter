package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

/**
 * Created by Luke on 2017-10-11.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));

        try {
            list.addTweet(tweet);
            assertTrue(Boolean.FALSE);
        }
        catch (IllegalArgumentException e) {
            //Do nothing
        }
    }

    public void testDelete() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        Tweet returnedTweet = list.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet one = new NormalTweet("one", new Date(5000));
        Tweet two = new NormalTweet("two", new Date(10000));
        Tweet three = new NormalTweet("three", new Date(50000));

        list.addTweet(three);
        list.addTweet(one);
        list.addTweet(two);

        List<Tweet> returnedTweets = list.getTweets();

        assertEquals(returnedTweets.get(0), one);
        assertEquals(returnedTweets.get(1), two);
        assertEquals(returnedTweets.get(2), three);
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet one = new NormalTweet("one", new Date(5000));
        Tweet two = new NormalTweet("two", new Date(10000));
        Tweet three = new NormalTweet("three", new Date(50000));

        list.addTweet(three);
        list.addTweet(one);
        list.addTweet(two);

        assertEquals(3, list.getCount());
    }

}
