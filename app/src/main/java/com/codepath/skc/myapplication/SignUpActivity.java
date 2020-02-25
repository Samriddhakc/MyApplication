package com.codepath.skc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG="SignUpActivity";
    private EditText rgUsername;
    private EditText rgPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toast.makeText(this, "Successfully inside Login",Toast.LENGTH_SHORT).show();
        rgUsername=findViewById(R.id.rgUsername);
        rgPassword=findViewById(R.id.rgPassword);
        btnRegister=findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=rgUsername.getText().toString();
                String password=rgPassword.getText().toString();
                Log.i(TAG,"on Register");
                Log.i(TAG,"Registering"+username);
                registerUser(username,password);
            }
        });
    }

    private void registerUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
    // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.i(TAG, "succesfullly registered");
                } else {
                    Log.e(TAG, "cannot register user", e);
                }
            }
        });
    }

}
