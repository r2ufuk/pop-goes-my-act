package com.r2ufuk.popgoesmyact.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r2ufuk.popgoesmyact.R;
import com.r2ufuk.popgoesmyact.data.repositories.ActorRepository;
import com.r2ufuk.popgoesmyact.domain.entities.Actor;
import com.r2ufuk.popgoesmyact.domain.interactors.GetPopularActors;
import com.r2ufuk.popgoesmyact.domain.interactors.Observer;
import com.r2ufuk.popgoesmyact.presentation.MyApplication;
import com.r2ufuk.popgoesmyact.presentation.model.ActorModel;
import com.r2ufuk.popgoesmyact.presentation.presenter.ActorListPresenter;
import com.r2ufuk.popgoesmyact.presentation.view.ActorListView;
import com.r2ufuk.popgoesmyact.presentation.view.adapter.ActorLayoutManager;
import com.r2ufuk.popgoesmyact.presentation.view.adapter.ActorListAdapter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.observers.DefaultObserver;

public class ActorListFragment extends BaseFragment implements ActorListView{

    ActorListPresenter actorListPresenter;
    ActorListAdapter actorListAdapter;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    public ActorListFragment() {
        setRetainInstance(true);
        this.actorListAdapter = new ActorListAdapter(MyApplication.getContext());
        actorListPresenter = new ActorListPresenter( new GetPopularActors(new ActorRepository()));
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.actor_list_fragment, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        Log.d("mytag", "Im alive :)");
        return fragmentView;
    }

    private void setupRecyclerView() {
        this.recyclerView.setLayoutManager(new ActorLayoutManager(MyApplication.getContext()));
        this.recyclerView.setAdapter(this.actorListAdapter);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.actorListPresenter.selectView(this);
        if (savedInstanceState == null) {
            this.loadActorList();
        }
    }


    @Override public void onResume() {
        super.onResume();
        this.actorListPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.actorListPresenter.pause();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        this.actorListPresenter.destroy();
    }

    @Override public void onDetach() {
        super.onDetach();
        this.actorListPresenter = null;
    }


    @Override public void showRetry() {

    }

    @Override public void hideRetry() {

    }

    @Override
    public void showError(String errorMessage) {
        toastyMessage(errorMessage);
    }

    private void loadActorList() {
        this.actorListPresenter.initialize();
    }

    @Override
    public void render(List<ActorModel> actorModelList) {
        this.actorListAdapter.setActorList(actorModelList);
    }


}
