package com.r2ufuk.popgoesmyact.domain.entities;

public class Actor {
    private final int id;
    private final float popularity;
    private final String name;
    private final String profile_path;

    public Actor(int id, float popularity, String name, String profile_path) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.profile_path = profile_path;
    }
}
