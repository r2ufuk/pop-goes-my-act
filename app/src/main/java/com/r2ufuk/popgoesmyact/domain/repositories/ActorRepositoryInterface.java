package com.r2ufuk.popgoesmyact.domain.repositories;

import com.r2ufuk.popgoesmyact.domain.entities.Actor;

import java.util.List;

import io.reactivex.Observable;

public abstract class ActorRepositoryInterface {

    public abstract Observable<List<Actor>> popularActors();

}
