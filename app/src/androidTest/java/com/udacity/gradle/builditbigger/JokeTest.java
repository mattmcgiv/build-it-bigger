package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Pair;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by matthewmcgivney on 1/11/16.
 */
public class JokeTest extends ActivityInstrumentationTestCase2<MainActivity> {
    String joke;
    private MainActivity mainActivity;
    private TextView jokeText;

    public JokeTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        jokeText = (TextView) mainActivity.findViewById(R.id.joke_textview);
    }

    public void testJokeReceived() {
        //Act
        new EndpointsAsyncTask(mainActivity).execute(new Pair<Context, String>(mainActivity, "Manfred"));
        try {
            //GetJokeTask jokeTask = new GetJokeTask();
            EndpointsAsyncTask eat = new EndpointsAsyncTask(mainActivity);
            eat.execute();
            joke = eat.get(30, TimeUnit.SECONDS);
        } catch (Exception e){
            fail("Timed out");
        }
        //Assert
        assertNotNull("Problem: Null value found instead of joke.", joke);
    }


}
