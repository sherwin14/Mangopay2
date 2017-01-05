package com.eurolink.mangopay.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.eurolink.mangopay.R;
import com.eurolink.mangopay.Utilities;
import com.eurolink.mangopay.manager.ApiManager;
import com.eurolink.mangopay.models.UserLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private Button login;
    private Button register;
    private EditText username;
    private EditText password;
    private Utilities utilities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadDefaults();

        username = (EditText) findViewById(R.id.loginUsername);
        password = (EditText) findViewById(R.id.loginPassword);

        login = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin(username.getText().toString(),password.getText().toString());
                application.getAuth().getUser().setUserName("sample");
                application.getAuth().getUser().setApiKey("sample");
            }
        });

        register = (Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,CardRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void doLogin(String username,String password){

        final ApiManager manager = new ApiManager();
        Call<UserLoginResponse> call = manager.userLogin().userLogin("user","sample","password",username,password,"read");
        call.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                boolean isAuth = response.body().getError() == null? false : true;

               if(!isAuth){
                   //  Log.d("Body:",response.body().getAccess_token());
                   utilities.setDefaults("access_token",response.body().getAccess_token(),getBaseContext());
                   application.getAuth()
                           .getUser()
                           .setIsLoggedIn(true);

                   startActivity(new Intent(LoginActivity.this,MainActivity.class));
                   finish();
                }else {
                   Toast.makeText(getBaseContext(),response.body().getError_description(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void loadDefaults(){
        utilities.setDefaults("client_id","user",getBaseContext());
        utilities.setDefaults("client_secret","sample",getBaseContext());
        utilities.setDefaults("grant_type","password",getBaseContext());
    }
}
