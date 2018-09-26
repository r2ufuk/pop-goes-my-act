package com.r2ufuk.popgoesmyact.presentation.presenter;

import android.support.annotation.NonNull;

import com.r2ufuk.popgoesmyact.domain.entities.Actor;

import com.r2ufuk.popgoesmyact.domain.interactors.GetPopularActors;
import com.r2ufuk.popgoesmyact.domain.interactors.Observer;
import com.r2ufuk.popgoesmyact.presentation.model.ActorModel;
import com.r2ufuk.popgoesmyact.presentation.model.ActorModelMapper;
import com.r2ufuk.popgoesmyact.presentation.view.ActorListView;

import java.util.List;

public class ActorListPresenter implements Presenter {
    private GetPopularActors getPopularActors;
    private ActorListView actorListView;

    public ActorListPresenter() {}

    public ActorListPresenter(GetPopularActors getPopularActors) {
        this.getPopularActors = getPopularActors;
    }

    public void initialize() {
        this.loadActorList();
    }

    private void loadActorList() {
        getActorList();
    }

    public void selectView(@NonNull ActorListView view) {
        this.actorListView = view;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {
        this.getPopularActors.dispose();
        this.actorListView = null;
    }

    private void getActorList() {
        this.getPopularActors.execute(new ActorListObserver());
    }

    private void presentError(String errorMessage) {
        this.actorListView.showError(errorMessage);
    }

    private void presentActorList(List<Actor> actorList) {
        List<ActorModel> actorModelList = ActorModelMapper.mapList(actorList);
        this.actorListView.render(actorModelList);
    }

    private final class ActorListObserver extends Observer<List<Actor>> {

        @Override public void onNext(List<Actor> actors) {
            presentActorList(actors);
        }

        @Override public void onError(Throwable e) {
            presentError(e.getMessage());
        }
    }

}
