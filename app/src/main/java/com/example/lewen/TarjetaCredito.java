package com.example.lewen;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class TarjetaCredito implements TextWatcher {
    private static final char space = ' ';
    private final EditText edtxtNumTar;
    private final ImageView img;

    public TarjetaCredito(EditText edtxtNumTar, ImageView img) {
        this.edtxtNumTar = edtxtNumTar;
        this.img = img;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        String secuencia = "\\d{4} \\d{4} \\d{4} \\d{4}";

        if (s.toString().matches(secuencia)) {
            img.setVisibility(View.VISIBLE);
        } else {
            edtxtNumTar.setError("Número de tarjeta incorrecto");
            img.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() > 0 && (s.length() % 5) == 0) {
            final char c = s.charAt(s.length() - 1);
            if (space == c) {
                s.delete(s.length() -1, s.length());
            }
        }
        if (s.length() > 0 && (s.length() % 5) == 0) {
            char c = s.charAt(s.length() - 1);
            if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                s.insert(s.length() -1, String.valueOf(space));
            }
        }
    }
}