package com.codepath.skc.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {


    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context,List<Post> posts) {
        this.context=context;
        this.posts=posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(context).inflate(R.layout.item_feed,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post=posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder
    {

        private TextView etUsername;
        private ImageView etImage;
        private  TextView etDescription;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            etUsername=itemView.findViewById(R.id.etUsername);
            etImage=itemView.findViewById(R.id.etImage);
            etDescription=itemView.findViewById(R.id.etDescription);

        }

        public void bind(Post post) {
            etUsername.setText(post.getUser().getUsername());
            etDescription.setText(post.getDescription());
            ParseFile image=post.getImage();
            if (image!=null)
            {
                Glide.with(context).load(image.getUrl()).into(etImage);
            }
        }
    }
}
