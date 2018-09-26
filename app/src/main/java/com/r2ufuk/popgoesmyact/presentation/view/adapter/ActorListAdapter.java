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
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.BindView;
import butterknife.ButterKnife;

//@Inject
@Singleton
public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ActorViewHolder> {

    private List<ActorModel> actorList = new ArrayList<>();
    private List<ActorModel> backupList = new ArrayList<>();
    private final LayoutInflater layoutInflater;



    @Inject
    public ActorListAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setActorList(List<ActorModel> paraActorList) {
        if(paraActorList == null){
            actorList.clear();
        } else{
            actorList.addAll(paraActorList);
        }
        backupList.clear();
        backupList.addAll(actorList);
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

    public void filterList(String query) {
        actorList.clear();
        if(query.equals("") || query.isEmpty()){
            actorList.addAll(backupList);
        } else{
            query = query.toLowerCase();
            for(ActorModel actorModel: backupList){
                if(actorModel.getName().toLowerCase().contains(query)){
                    actorList.add(actorModel);
                }
            }
        }
        this.notifyDataSetChanged();
    }

    public void printListCount(TextView view){
        view.setText(Integer.toString(getItemCount()));
    }


    @Override
    public int getItemCount() {
        return (actorList != null) ? actorList.size() : 0;
    }

    static class ActorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.actorImage)
        ImageView actorImage;
        @BindView(R.id.actorName)
        TextView actorName;
        @BindView(R.id.actorPopularity)
        TextView actorPopularity;

        ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
