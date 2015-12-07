package com.example.maia.rocha.vinicius.economizeapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


import com.example.maia.rocha.vinicius.economizeapp.R;
import com.example.maia.rocha.vinicius.economizeapp.activities.MainActivity;

/**
 * Created by vinicius on 05/08/15.
 */
public class MililitroFragment extends Fragment {


    private EditText edtMl1;
    private EditText edtMl2;
    private EditText edtPriceMili1;
    private EditText edtPriceMili2;
    private Button btnCompare;
    private Button btnClearMil;



    private final int CONST_ML_VALUE  = 100;
    private float firstPrice100ml;
    private float secondPrice100ml;




//    public MililitroFragment(float price, float mililitro) {
//
//        this.price = price;
//        this.mililitro = mililitro;
//    }
//
//


    public static MililitroFragment newInstance() {

      //  MililitroFragment fragment =  new MililitroFragment();
       // fragment.setArguments(args);
        return new MililitroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab_ml_layout,container,false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final View root = getView();

        if(root != null) {

            edtMl1 = (EditText) root.findViewById(R.id.edtMl1);
            edtMl2 = (EditText) root.findViewById(R.id.edtMl2);
            edtPriceMili1 = (EditText) root.findViewById(R.id.edtPriceMili1);
            edtPriceMili2 = (EditText) root.findViewById(R.id.edtPriceMili2);

            btnCompare = (Button) root.findViewById(R.id.btnCompareMili);
            btnClearMil = (Button) root.findViewById(R.id.btnClearMl);

            btnCompare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (edtMl1.getText().toString().equals("") || edtMl2.getText().toString().equals("") || edtPriceMili1.getText().toString().equals("") || edtPriceMili2.getText().toString().equals(""))
                        Toast.makeText(getActivity(),R.string.fillAllTheBlanks,Toast.LENGTH_SHORT).show();

                    else {

                        firstPrice100ml = (Float.valueOf(edtPriceMili1.getText().toString()) * CONST_ML_VALUE) / (Float.valueOf(edtMl1.getText().toString()));
                        secondPrice100ml = (Float.valueOf(edtPriceMili2.getText().toString()) * CONST_ML_VALUE) / (Float.valueOf(edtMl2.getText().toString()));

                        if(firstPrice100ml < secondPrice100ml)
                            Toast.makeText(getActivity(),"First option",Toast.LENGTH_SHORT).show();
                        else if( secondPrice100ml < firstPrice100ml)
                            Toast.makeText(getActivity(),"Second Option",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(),"Equals",Toast.LENGTH_SHORT).show();
                    }


                }
            });


            btnClearMil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    edtMl1.setText("");
                    edtMl2.setText("");
                    edtPriceMili1.setText("");
                    edtPriceMili2.setText("");
                }
            });



        } else
            Toast.makeText(getActivity(),R.string.viewProblem,Toast.LENGTH_SHORT).show();

    }
}
