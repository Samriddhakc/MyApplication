package com.codepath.skc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    private EditText Description;
    private Button btnCaptureImage;
    private Button btnSubmit;
    private ImageView ivPostImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Description = findViewById(R.id.etDescription);
        btnCaptureImage = findViewById(R.id.btnCaptureImage);
        btnSubmit= findViewById(R.id.btnSubmit);
        ivPostImage=findViewById(R.id.ivPostImage);
        queryPosts();
    }

    private void queryPosts() {
        ParseQuery<Post> query= ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e!=null)
                {
                    Log.e(TAG,"Not getting Posts!",e);
                }

                for(Post post:posts){
                    Log.i(TAG,"Post:"+post.getDescription()+",Username"+post.getUser().getUsername());
                }

            }
        });
    }


}