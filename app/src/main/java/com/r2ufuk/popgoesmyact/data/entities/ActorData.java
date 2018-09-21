package com.r2ufuk.popgoesmyact.data.entities;

import com.google.gson.annotations.SerializedName;

public class ActorData {

    @SerializedName("id")
    private int userId;

    @SerializedName("name")
    private String name;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("profile_path")
    private String profile_path;

    public ActorData(int userId, String name, double popularity, String profile_path) {
        this.userId = userId;
        this.name = name;
        this.popularity = popularity;
        this.profile_path = profile_path;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
