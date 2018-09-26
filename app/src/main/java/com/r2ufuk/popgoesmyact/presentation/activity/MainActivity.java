package com.r2ufuk.popgoesmyact.presentation.activity;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.r2ufuk.popgoesmyact.R;
import com.r2ufuk.popgoesmyact.presentation.view.adapter.ActorListAdapter;
import com.r2ufuk.popgoesmyact.presentation.view.fragment.ActorListFragment;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.search) SearchView search;
    @BindView(R.id.mainWindow) LinearLayout mainWindow;
    @BindView(R.id.searchCount) TextView searchCount;

    ActorListAdapter actorListAdapter;
    ActorListFragment actorListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        actorListAdapter = new ActorListAdapter(this);
        actorListFragment = new ActorListFragment();
        actorListFragment.setAdapter(actorListAdapter);


        if (savedInstanceState == null) {
            addFragment(R.id.listContainer, actorListFragment);
        }

        this.search.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        actorListAdapter.filterList(query);
                        actorListAdapter.printListCount(searchCount);
                        unFocus();
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String query) {
                        actorListAdapter.filterList(query);
                        actorListAdapter.printListCount(searchCount);
                        return true;
                    }
                }
                );


        this.search.setOnCloseListener(() -> {
            actorListAdapter.filterList("");
            searchCount.setText("");
            unFocus();
            return true;
        });

//        mainWindow.setOnTouchListener((v, event) -> {
//            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//            return true;
//        });

    }

    private void unFocus(){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
        }
    }






}
