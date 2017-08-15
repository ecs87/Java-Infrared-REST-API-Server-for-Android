package com.elsonsmith.IRRESTAPIServer;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ecs87IRRESTAPIServer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleWebServer.context = this;
        setContentView(R.layout.activity_test);
        final ConsumerIrManager mCIR;
        mCIR = (ConsumerIrManager)getSystemService(Context.CONSUMER_IR_SERVICE);
        if (!mCIR.hasIrEmitter()) {
            Log.e(TAG, "No IR Emitter found\n");
            Toast.makeText(getApplicationContext(), "No IR Emitters found.", Toast.LENGTH_LONG).show();
        }
        else {
            SimpleWebServer webServerStart = new SimpleWebServer(8080);
            webServerStart.start();
        }
    }
}