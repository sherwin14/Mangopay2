package com.eurolink.mangopay.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sherwin on 12/22/2016.
 */

public class UserLoginResponse {

    @SerializedName("access_token")
    @Expose
    private String access_token;

    @SerializedName("expires_in")
    @Expose
    private String expires_in;

    @SerializedName("token_type")
    @Expose
    private String token_type;

    @SerializedName("scope")
    @Expose
    private String scope;

    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("error_description")
    @Expose
    private String error_description;

    public UserLoginResponse(String access_token, String expires_in, String token_type, String scope, String refresh_token) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.scope = scope;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }


    public String getExpires_in() {
        return expires_in;
    }


    public String getToken_type() {
        return token_type;
    }


    public String getScope() {
        return scope;
    }



    public String getRefresh_token() {
        return refresh_token;
    }


    public String getError() {
        return error;
    }


    public String getError_description() {
        return error_description;
    }


}
