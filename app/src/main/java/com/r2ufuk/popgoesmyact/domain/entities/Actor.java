package com.r2ufuk.popgoesmyact.domain.entities;

public class Actor {
    private final int id;
    private final double popularity;
    private final String name;
    private final String profile_path;

    public Actor(int id, double popularity, String name, String profile_path) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.profile_path = profile_path;
    }

    public int getId() {
        return id;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getName() {
        return name;
    }

    public String getProfile_path() {
        return profile_path;
    }
}
