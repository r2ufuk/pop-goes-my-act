package com.r2ufuk.popgoesmyact.presentation.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

public class BaseFragment extends Fragment{

    protected void toastyMessage(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
    }

}
