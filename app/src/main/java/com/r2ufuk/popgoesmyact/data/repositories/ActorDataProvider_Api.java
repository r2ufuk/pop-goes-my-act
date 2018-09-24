package com.r2ufuk.popgoesmyact.data.repositories;

import com.r2ufuk.popgoesmyact.data.entities.ActorData;
import com.r2ufuk.popgoesmyact.data.web.Api;

import java.util.List;

import io.reactivex.Observable;

public class ActorDataProvider_Api implements ActorDataProvider {

    private Api api;

    ActorDataProvider_Api(Api api){
        this.api = api;
    }

    @Override
    public Observable<List<ActorData>> actorList(int pageNum) {
        return this.api.actorDataList(pageNum);
    }
}
