package com.eurolink.mangopay.infrastructure;

import android.app.Application;

/**
 * Created by Sherwin on 12/20/2016.
 */

public class MangoPay extends Application {
    private Auth auth;


    @Override
    public void onCreate() {
        super.onCreate();
        auth = new Auth(MangoPay.this);
    }

    public Auth getAuth() {
        return auth;
    }
}
