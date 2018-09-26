package com.r2ufuk.popgoesmyact.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r2ufuk.popgoesmyact.R;
import com.r2ufuk.popgoesmyact.data.repositories.ActorRepository;
import com.r2ufuk.popgoesmyact.domain.interactors.GetPopularActors;
import com.r2ufuk.popgoesmyact.presentation.MyApplication;
import com.r2ufuk.popgoesmyact.presentation.model.ActorModel;
import com.r2ufuk.popgoesmyact.presentation.presenter.ActorListPresenter;
import com.r2ufuk.popgoesmyact.presentation.view.ActorListView;
import com.r2ufuk.popgoesmyact.presentation.view.adapter.ActorLayoutManager;
import com.r2ufuk.popgoesmyact.presentation.view.adapter.ActorListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActorListFragment extends BaseFragment implements ActorListView {

    ActorListPresenter actorListPresenter;
    ActorListAdapter actorListAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    public ActorListFragment() {
        setRetainInstance(true);
        ActorRepository actorRepository = new ActorRepository();
        actorListPresenter = new ActorListPresenter(new GetPopularActors(actorRepository));
    }

    public void setAdapter(ActorListAdapter actorListAdapter){
        this.actorListAdapter = actorListAdapter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.actor_list_fragment, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    private void setupRecyclerView() {
        this.recyclerView.setLayoutManager(new ActorLayoutManager(MyApplication.getContext()));
        this.recyclerView.setAdapter(this.actorListAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.actorListPresenter.selectView(this);
        if (savedInstanceState == null) {
            this.loadActorList();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        this.actorListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.actorListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.actorListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.actorListPresenter = null;
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
