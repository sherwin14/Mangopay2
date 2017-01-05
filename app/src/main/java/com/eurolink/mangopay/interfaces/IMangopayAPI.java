package com.eurolink.mangopay.interfaces;

import com.eurolink.mangopay.models.UserLoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Sherwin on 12/22/2016.
 */

public interface IMangopayAPI {

    @FormUrlEncoded
    @POST("oauth/token")
    Call<UserLoginResponse> userLogin(@Field("client_id") String client_id,
                                      @Field("client_secret") String client_secret,
                                      @Field("grant_type") String grant_type,
                                      @Field("username") String username,
                                      @Field("password") String password,
                                      @Field("scope") String scope);
}
