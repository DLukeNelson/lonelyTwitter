/*
 * LonelyTwitterActivity
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents the Lonely Twitter Activity
 *
 * @author dlnelson
 * @version 1.5
 */
public class LonelyTwitterActivity extends Activity {
	private static final String FILENAME = "file.sav";

	private EditText bodyText;
	private ListView oldTweetsList;
	private List<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState Sent by android stack.
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

                try {
                    tweets.add(new NormalTweet(text));
                } catch (TweetTooLongException e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
                bodyText.setText("");

                saveInFile();
				//finish();
			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tweets.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });

	}

    /**
     * Called after onCreate or after onStart.
     */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Loads a saved list of tweets from the file.
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            tweets = new ArrayList<Tweet>();
		}
	}

    /**
     * Saves the current list of tweets to the file.
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(tweets,osw);
            osw.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException();
		}
	}
}