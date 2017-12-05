package com.udacity.gradle.builditbigger;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * This test case is for check when AsynTask is not null.
 */
public class EndpointsAsyncTaskTest {

    @Test
    public void onPostExecute() throws Exception {
        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        mainActivityFragment.testingFlag = true;
        new EndpointsAsyncTask().execute(mainActivityFragment);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + mainActivityFragment.joke, mainActivityFragment.joke != null);
    }
}