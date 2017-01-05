package com.eurolink.mangopay.manager;

import com.eurolink.mangopay.interfaces.IMangopayAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.eurolink.mangopay.Constants.*;
/**
 * Created by Sherwin on 12/22/2016.
 */

public class ApiManager {
    private IMangopayAPI mangopayAPI;

    public IMangopayAPI userLogin(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mangopayAPI = retrofit.create(IMangopayAPI.class);
        return mangopayAPI;
    }
}
