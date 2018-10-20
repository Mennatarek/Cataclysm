package com.cataclysm.android.cataclysm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.attr.gestureColor;
import static android.R.attr.id;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewholder> {
    List<Home_Getters> list;
    Context context;
    int[] myImageList = new int[]{R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four};


    public HomeAdapter(List<Home_Getters> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homesinglerow, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewholder holder, int position) {
        Home_Getters info = list.get(position);
        final String username = info.getUsername();
        final String location = info.getLocation();
        final String body = info.getPost_body();
        final String post_img = info.getPost_img();


        ///////////

        holder.location.setText(location);
        holder.post_body.setText(body);
        holder.username.setText(username);
        //holder.post_img.setImageDrawable(R.drawable.one);
/////////
        Picasso.with(context).load(myImageList[Integer.parseInt(post_img)]).into(holder.post_img);
        holder.vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.vote.setText("1");
                holder.vote.setBackgroundColor(context.getColor(R.color.colorbutton));
                holder.vote.setTextColor(context.getColor(R.color.colortextbutton));
                ////
                holder.downvote.setText("0");
                holder.downvote.setBackgroundColor(context.getColor(R.color.colortextbutton));
                holder.vote.setTextColor(context.getColor(R.color.colortextbuttonblack));

            }
        });
        holder.downvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downvote.setText("1");
                holder.downvote.setBackgroundColor(context.getColor(R.color.colorbutton));
                holder.downvote.setTextColor(context.getColor(R.color.colortextbutton));
                ////
                holder.vote.setText("0");
                holder.vote.setBackgroundColor(context.getColor(R.color.colortextbutton));
                holder.downvote.setTextColor(context.getColor(R.color.colortextbuttonblack));

            }
        });
        holder.tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tweet = new Intent(Intent.ACTION_SEND);

                tweet.putExtra(Intent.EXTRA_TEXT, body);
                tweet.setType("text/plain");
                v.getContext().startActivity(Intent.createChooser(tweet, "Share this via"));

            }
        });

        holder.maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Content.class);
                intent.putExtra("body", body);
                intent.putExtra("username", username);
                intent.putExtra("location", location);
                intent.putExtra("post_img", post_img);

                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView location, post_body, username;
        ImageView post_img;
        Button vote, downvote, tweet;
        LinearLayout maincontent;


        public MyViewholder(View itemView) {
            super(itemView);
            location = (TextView) itemView.findViewById(R.id.location);
            username = (TextView) itemView.findViewById(R.id.username);
            post_body = (TextView) itemView.findViewById(R.id.body);
            post_img = (ImageView) itemView.findViewById(R.id.post_img);
            vote = (Button) itemView.findViewById(R.id.vote);
            downvote = (Button) itemView.findViewById(R.id.downvote);
            tweet = (Button) itemView.findViewById(R.id.tweet);
            maincontent = (LinearLayout) itemView.findViewById(R.id.main_content);

        }
    }
}
