package com.r2ufuk.popgoesmyact.domain.repository;

import com.r2ufuk.popgoesmyact.domain.entities.Actor;

import java.util.List;

import io.reactivex.Observable;

public interface ActorRepository {

    Observable<List<Actor>> popularActors();

}
