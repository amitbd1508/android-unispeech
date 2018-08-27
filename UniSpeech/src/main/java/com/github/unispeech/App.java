package com.github.unispeech;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import com.nuance.nmdp.speechkit.SpeechKit;

/**
 * Created by javier.romero on 2/5/14.
 */
public class App extends Application {


    private SpeechKit mSpeechKit;

    @Override
    public void onCreate() {
        super.onCreate();

        byte [] x =null;
        mSpeechKit = SpeechKit.initialize(
                this.getApplicationContext(),
                "",
                "",
                443, false,x);

        mSpeechKit.connect();
    }

    public SpeechKit getSpeechKit() {
        return mSpeechKit;
    }

    public static boolean runningOnGoogleGlass() {
        Log.v("@@@", "DEVICE: " + Build.DEVICE);
        Log.v("@@@", "MODEL: " + Build.MODEL);
        Log.v("@@@", "PRODUCT: " + Build.PRODUCT);
        return Build.DEVICE.contains("glass");
    }
}
