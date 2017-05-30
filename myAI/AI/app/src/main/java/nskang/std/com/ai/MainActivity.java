package nskang.std.com.ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nskang.std.com.AI_Service.AI_Service_Main;

public class MainActivity  extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    Intent main_service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "============= MainActivity ==========  ");
        if(!AI_Service_Main.Get_Is_Running()) {
            main_service = new Intent(MainActivity.this, AI_Service_Main.class);
            startService(main_service);
        }
    }
}
