package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView tweet = (TextView) findViewById(R.id.answerGoesHere);

        Intent intent = getIntent();
        String s = intent.getStringExtra("Tweet");
        tweet.setText(s);

    }
}
