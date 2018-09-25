package com.r2ufuk.popgoesmyact.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.r2ufuk.popgoesmyact.R;
import com.r2ufuk.popgoesmyact.presentation.model.ActorModel;
import com.r2ufuk.popgoesmyact.presentation.view_model.ActorViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ActorViewHolder> {

    private List<ActorModel> actorList;
    private final LayoutInflater layoutInflater;

    public ActorListAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.actorList = new ArrayList<>();
    }

    public void setActorList(List<ActorModel> actorList) {
        if(actorList == null){
            this.actorList.clear();
        } else{
            this.actorList.addAll(actorList);
        }
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.actor_cell, viewGroup, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder actorViewHolder, int i) {
        ActorModel actorModel = actorList.get(i);
        actorViewHolder.actorName.setText(actorModel.getName());
        actorViewHolder.actorPopularity.setText(String.format(Locale.US, "%.2f", actorModel.getPopularity()));
        if (actorModel.getProfile_path() != null) {

            ActorViewModel.loadImage(actorViewHolder.actorImage, actorModel.getProfile_path());
        }
    }

    @Override
    public int getItemCount() {
        return (this.actorList != null) ? this.actorList.size() : 0;
    }

    static class ActorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.actorImage)
        ImageView actorImage;
        @BindView(R.id.actorName)
        TextView actorName;
        @BindView(R.id.actorPopularity)
        TextView actorPopularity;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
