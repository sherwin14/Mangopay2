package com.eurolink.mangopay.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.eurolink.mangopay.infrastructure.MangoPay;

/**
 * Created by Sherwin on 12/20/2016.
 */

public class BaseActivity extends AppCompatActivity {
    protected MangoPay application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (MangoPay) getApplication();
    }
}
