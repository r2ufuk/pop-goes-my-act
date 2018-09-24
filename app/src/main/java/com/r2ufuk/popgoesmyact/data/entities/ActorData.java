package com.r2ufuk.popgoesmyact.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActorData {

    @Expose
    @SerializedName("id")
    private final int id;

    @Expose
    @SerializedName("name")
    private final String name;

    @Expose
    @SerializedName("popularity")
    private final double popularity;

    @Expose
    @SerializedName("profile_path")
    private final String profile_path;

    public ActorData(int id, String name, double popularity, String profile_path) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.profile_path = profile_path;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }
}
