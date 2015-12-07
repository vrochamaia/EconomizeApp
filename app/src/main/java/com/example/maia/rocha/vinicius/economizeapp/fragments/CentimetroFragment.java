package com.example.maia.rocha.vinicius.economizeapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maia.rocha.vinicius.economizeapp.Masks.MonetaryMask;
import com.example.maia.rocha.vinicius.economizeapp.R;
import com.example.maia.rocha.vinicius.economizeapp.activities.CompareActivity;

/**
 * Created by vinicius on 06/08/15.
 */
public class CentimetroFragment extends Fragment {


    private EditText edtCm1;
    private EditText edtCm2;
    private EditText edtPriceCenti1;
    private EditText edtPriceCenti2;
    private Button btnCompareCenti;
    private Button btnClearCenti;

    private final int CONST_CENTI_VALUE = 100;

    private float firstPrice100centi;
    private float secondPrice100centi;


//    public CentimetroFragment(float centimetros, float price) {
//        this.centimetros = centimetros;
//        this.price = price;
//    }

    public static CentimetroFragment newInstance() {

        return new CentimetroFragment();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_cm_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final View root = getView();

        if(root != null) {

            edtCm1 = (EditText) root.findViewById(R.id.edtCm1);
            edtCm2 = (EditText) root.findViewById(R.id.edtCm2);
            edtPriceCenti1 = (EditText) root.findViewById(R.id.edtPriceCenti1);
            edtPriceCenti2 = (EditText) root.findViewById(R.id.edtPriceCenti2);

            btnCompareCenti = (Button) root.findViewById(R.id.btnCompareCenti);
            btnClearCenti = (Button) root.findViewById(R.id.btnClearCenti);
//
//            edtPriceCenti1.addTextChangedListener(new MonetaryMask());
//            edtPriceCenti2.addTextChangedListener(new MonetaryMask());

            btnCompareCenti.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (edtCm1.getText().toString().equals("") || edtCm2.getText().toString().equals("") || edtPriceCenti1.getText().toString().equals("") || edtPriceCenti2.getText().toString().equals(""))
                        Toast.makeText(getActivity(), R.string.fillAllTheBlanks, Toast.LENGTH_SHORT).show();

                    else {

                        firstPrice100centi = (Float.valueOf(edtPriceCenti1.getText().toString()) * CONST_CENTI_VALUE) / (Float.valueOf(edtCm1.getText().toString()));
                        secondPrice100centi = (Float.valueOf(edtPriceCenti2.getText().toString()) * CONST_CENTI_VALUE) / (Float.valueOf(edtCm2.getText().toString()));

                        if (firstPrice100centi < secondPrice100centi)
                            Toast.makeText(getActivity(), "First option", Toast.LENGTH_SHORT).show();
                        else if (secondPrice100centi < firstPrice100centi)
                            Toast.makeText(getActivity(), "Second Option", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "Equals", Toast.LENGTH_SHORT).show();

                    }

                }
            });

            btnClearCenti.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    edtCm1.setText("");
                    edtCm2.setText("");
                    edtPriceCenti1.setText("");
                    edtPriceCenti2.setText("");
                }
            });




        } else
            Toast.makeText(getActivity(),R.string.viewProblem,Toast.LENGTH_SHORT).show();

    }
}
