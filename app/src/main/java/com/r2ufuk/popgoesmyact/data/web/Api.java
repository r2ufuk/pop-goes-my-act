package com.r2ufuk.popgoesmyact.data.web;

import com.r2ufuk.popgoesmyact.data.entities.ActorData;
import com.r2ufuk.popgoesmyact.data.entities.ActorDataDeserialization;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class Api {

    public Api() {}

    public Observable<List<ActorData>> actorDataList(int pageNum){
        ApiUtil apiUtil = ApiUtil.getPageApi(pageNum);

        return Observable.create((ObservableEmitter<List<ActorData>> emitter) -> {

            String responseStr = apiUtil.getResponse();
            if (responseStr != null) {
                emitter.onNext(ActorDataDeserialization.createActorDataList(responseStr));
                emitter.onComplete();
            }
        });
    }

    private boolean checkConnection() throws IOException, InterruptedException {
//        String command = "ping -c 1 themoviedb.org";
//        return (Runtime.getRuntime().exec(command).waitFor() == 0);
        return InetAddress.getByName("themoviedb.org").isReachable(2000);
    }
}
