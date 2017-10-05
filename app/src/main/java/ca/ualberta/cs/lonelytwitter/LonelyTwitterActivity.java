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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweet> tweetList = new ArrayList<NormalTweet>();
	private ArrayAdapter<NormalTweet> adapter;



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
				NormalTweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				//saveInFile(); // TODO replace this with elastic search
                ElasticsearchTweetController.AddTweetsTask addTweetsTask
                        = new ElasticsearchTweetController.AddTweetsTask();
                addTweetsTask.execute(newTweet);
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
                ElasticsearchTweetController.GetTweetsTask getTweetsTask
                        = new ElasticsearchTweetController.GetTweetsTask();
                JSONObject json1 = new JSONObject();
                JSONObject json2 = new JSONObject();
                JSONObject json3 = new JSONObject();
                Log.d("Hi", "HERE I AM!");
                try {
                    json1.put("message", "does"); //bodyText.getText().toString());
                    json2.put("term", json1);
                    json3.put("query", json2).put("size", "5");
                }
                catch (Exception e) {
                    Log.i("Error", "Unable to convert input to JSON.");
                }
                Log.d("Hi", "THIS IS ME!");
                try {
                    getTweetsTask.execute(json3.toString());
                    ArrayList<NormalTweet> temp = getTweetsTask.get();
                    tweetList.clear();
                    tweetList.addAll(temp);
                    Log.d("Hi", tweetList.toString());
                    adapter.notifyDataSetChanged();
                }
                catch (Exception e) {
                    Log.i("Error", "Failed to get the tweets from the async object.");
                }
			}
		});


	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//loadFromFile(); // TODO replace this with elastic search
        ElasticsearchTweetController.GetTweetsTask getTweetsTask
                = new ElasticsearchTweetController.GetTweetsTask();
        getTweetsTask.execute("");

        try {
            tweetList = getTweetsTask.get();
        }
        catch (Exception e) {
            Log.i("Error", "Failed to get the tweets from the async object.");
        }
		adapter = new ArrayAdapter<NormalTweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}


	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22,2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<NormalTweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}


	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}