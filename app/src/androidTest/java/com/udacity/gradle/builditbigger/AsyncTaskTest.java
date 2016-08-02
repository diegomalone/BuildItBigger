package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

/**
 * Created by Malone on 10/10/2015.
 */
public class AsyncTaskTest extends ActivityInstrumentationTestCase2<BaseMainActivity> {

    private BaseMainActivity mMainActivity;
    private Button mButton;

    public AsyncTaskTest() {
        super(BaseMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mMainActivity = getActivity();
        mButton = (Button) mMainActivity.findViewById(R.id.button);
    }

    @MediumTest
    public void testAsyncTask() throws InterruptedException {
        TouchUtils.clickView(this, mButton);
        Thread.sleep(5000);
        String joke = mMainActivity.getJoke();
        assertTrue(joke != null && !joke.equals(""));
    }
}
