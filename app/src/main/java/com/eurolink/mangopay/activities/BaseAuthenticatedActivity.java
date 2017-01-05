package com.eurolink.mangopay.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by Sherwin on 12/20/2016.
 */

public abstract class BaseAuthenticatedActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!application.getAuth().getUser().isLoggedIn()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
            return;
        }

        onAppCreated(savedInstanceState);

    }

    protected abstract void onAppCreated(Bundle savedState );
}
