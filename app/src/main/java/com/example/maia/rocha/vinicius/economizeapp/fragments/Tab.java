package com.example.maia.rocha.vinicius.economizeapp.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maia.rocha.vinicius.economizeapp.R;

/**
 * Created by vinicius on 04/08/15.
 */
public class Tab extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Tab newInstance() {

      //  Tab fragment =  new Tab();
      //  fragment.setArguments(args);
        return new Tab();


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_layout,container,false);
        TextView textView = (TextView) view.findViewById(R.id.tabtextview);
        textView.setText("Fragment #" + mPage);
        return view;
    }
}
