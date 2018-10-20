package com.cataclysm.android.cataclysm;



public class Home_Getters {
    String post_id,location,post_body,votes,post_img,username;

    public Home_Getters(String post_id,String location,String post_body,String votes,String post_img,String username) {

        this.post_id = post_id;
        this.location = location;
        this.post_body= post_body;
        this.votes=votes;
        this.post_img = post_img;
        this.username = username;

    }

    public String getPost_id() {
        return post_id;
    }

    public String getLocation() {
        return location;
    }

    public String getPost_body() {
        return post_body;
    }

    public String getVotes() {
        return votes;
    }

    public String getPost_img() {
        return post_img;
    }

    public String getUsername() {
        return username;
    }
}
