package com.r2ufuk.popgoesmyact.presentation.view;

import com.r2ufuk.popgoesmyact.presentation.model.ActorModel;

import java.util.List;

public interface ActorListView extends BaseView {
    void render(List<ActorModel> actorModelList);
}
