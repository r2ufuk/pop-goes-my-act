package com.r2ufuk.popgoesmyact.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.r2ufuk.popgoesmyact.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Api api = new Api();
//        JsonObjectRequest jsonObjectRequest = api.requestPopular(1);
//
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}
