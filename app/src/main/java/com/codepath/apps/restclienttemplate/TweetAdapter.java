package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    Context context;
    List<Tweet> tweets;

    public TweetAdapter (Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.bind(tweet);
    }

    public int getItemCount() {
        return tweets.size();
    }

    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImg;
        TextView tvBody;
        TextView name;
        TextView screenName;
        TextView timeStamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.profileImg);
            tvBody = itemView.findViewById(R.id.tvBody);
            name = itemView.findViewById(R.id.name);
            screenName = itemView.findViewById(R.id.screenName);
            timeStamp = itemView.findViewById(R.id.timeStamp);
        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            timeStamp.setText("· " + tweet.timeStamp);
            name.setText(tweet.user.name);
            screenName.setText("@" + tweet.user.screenName);
            Glide.with(context).load(tweet.user.profileImgURL).into(profileImg);
        }
    }
}
