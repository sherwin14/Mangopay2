package com.eurolink.mangopay.infrastructure;

import android.content.Context;

/**
 * Created by Sherwin on 12/20/2016.
 */

public class Auth {
    private final Context context;
    private  User user;

    public Auth(Context context){
        this.context = context;
        user = new User();
    }

    public User getUser() {
        return user;
    }
}
