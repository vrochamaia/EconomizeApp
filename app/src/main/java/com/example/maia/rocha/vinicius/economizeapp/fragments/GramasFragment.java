package com.example.maia.rocha.vinicius.economizeapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maia.rocha.vinicius.economizeapp.R;

/**
 * Created by vinicius on 06/08/15.
 */
public class GramasFragment extends Fragment {


    private EditText edtGm1;
    private EditText edtGm2;
    private EditText edtPriceGramas1;
    private EditText edtPriceGramas2;
    private Button btnCompareGramas;
    private Button btnClearGramas;

    private final int CONST_GRAMAS_VALUE = 100;

    private float firstPrice100gm;
    private float secondPrice100gm;


//
//    public GramasFragment(float gramas, float price) {
//        this.gramas = gramas;
//        this.price = price;
//    }

    public static GramasFragment newInstance() {

        return new GramasFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab_gm_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final View root = getView();

        if(root != null)  {

            edtGm1 = (EditText) root.findViewById(R.id.edtGm1);
            edtGm2 = (EditText) root.findViewById(R.id.edtGm2);
            edtPriceGramas1 = (EditText) root.findViewById(R.id.edtPriceGramas1);
            edtPriceGramas2 = (EditText) root.findViewById(R.id.edtPriceGramas2);

            btnCompareGramas = (Button) root.findViewById(R.id.btnCompareGramas);
            btnClearGramas = (Button) root.findViewById(R.id.btnClearGramas);

            btnCompareGramas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (edtGm1.getText().toString().equals("") || edtGm2.getText().toString().equals("") || edtPriceGramas1.getText().toString().equals("") || edtPriceGramas2.getText().toString().equals(""))

                        Toast.makeText(getActivity(),R.string.fillAllTheBlanks, Toast.LENGTH_SHORT).show();
                    else {

                        firstPrice100gm = (Float.valueOf(edtPriceGramas1.getText().toString()) * CONST_GRAMAS_VALUE) / (Float.valueOf(edtGm1.getText().toString()));
                        secondPrice100gm = (Float.valueOf(edtPriceGramas2.getText().toString()) * CONST_GRAMAS_VALUE) / (Float.valueOf(edtGm2.getText().toString()));


                        if(firstPrice100gm < secondPrice100gm)
                            Toast.makeText(getActivity(),"First option",Toast.LENGTH_SHORT).show();
                        else if( secondPrice100gm < firstPrice100gm)
                            Toast.makeText(getActivity(),"Second Option",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(),"Equals",Toast.LENGTH_SHORT).show();

                    }


                }
            });

            btnClearGramas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    edtGm1.setText("");
                    edtGm2.setText("");
                    edtPriceGramas1.setText("");
                    edtPriceGramas2.setText("");
                }
            });

        } else
            Toast.makeText(getActivity(),R.string.viewProblem, Toast.LENGTH_SHORT).show();


    }
}
