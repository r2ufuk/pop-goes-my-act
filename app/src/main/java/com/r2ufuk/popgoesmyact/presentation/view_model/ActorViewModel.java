package com.r2ufuk.popgoesmyact.presentation.view_model;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.r2ufuk.popgoesmyact.R;
import com.r2ufuk.popgoesmyact.presentation.MyApplication;


import static com.r2ufuk.popgoesmyact.data.constants.Constant.image_base_url;
import static com.r2ufuk.popgoesmyact.presentation.MyApplication.getContext;

public class ActorViewModel {

    private String imageUrl;

    public ActorViewModel(String imgUrl){
        imageUrl = imgUrl;
    }


    public static void loadImage(ImageView view, String imageUrl) {
        String fullUrl = image_base_url + imageUrl;
        Glide.with(MyApplication.getContext())
                .load(fullUrl)
                .into(view);
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
