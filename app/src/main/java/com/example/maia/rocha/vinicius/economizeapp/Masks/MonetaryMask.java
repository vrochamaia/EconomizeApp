package com.example.maia.rocha.vinicius.economizeapp.Masks;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * Created by vinicius on 08/08/15.
 */
public class MonetaryMask implements TextWatcher {

    private boolean isUpdating;
    private EditText mEditText;
    private NumberFormat mNF = NumberFormat.getCurrencyInstance();

    @Override
    public void onTextChanged(CharSequence cs, int start, int before, int after) {
        if (isUpdating) {
            isUpdating = false;
            return;
        }

        isUpdating = true;
        String str = cs.toString();
        boolean hasMask = (str.indexOf("R$") >= 0 && str.indexOf(".") >= 0 && str.indexOf(",") >= 0);

        if (hasMask) {
            str = str.replaceAll("[R$]", "").replaceAll("[.]", "").replaceAll("[,]", "");
        }

        try {
            double value = (Double.parseDouble(str) / 100);
            str = mNF.format(value);
            mEditText.setText(str);
            mEditText.setSelection(str.length());
        } catch (Exception e) {
         //   e.printStackTrance();
            e.printStackTrace();
       //     cs.clear();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence cs, int start, int count, int after) {
        // Não iremos utilizar...
    }

    @Override
    public void afterTextChanged(Editable e) {
        // Não iremos utilizar...
    }
}
