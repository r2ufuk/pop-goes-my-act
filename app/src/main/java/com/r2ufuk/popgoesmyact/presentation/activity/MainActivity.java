package com.r2ufuk.popgoesmyact.presentation.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.r2ufuk.popgoesmyact.R;
import com.r2ufuk.popgoesmyact.presentation.view.fragment.ActorListFragment;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.android.volley.toolbox.Volley.newRequestQueue;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            addFragment(R.id.listContainer, new ActorListFragment());
        }

    }

}
