package com.example.lewen;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private Button btnIniciar;
    private EditText edtxtUser, edtxtPwd;
    private ConexionSQL conexionSQL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        edtxtUser = view.findViewById(R.id.edtxtUser);
        edtxtPwd = view.findViewById(R.id.edtxtPwd);
        btnIniciar = view.findViewById(R.id.btnIniciar);
        conexionSQL = new ConexionSQL(getContext());

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edtxtUser.getText().toString();
                String pwd = edtxtPwd.getText().toString();

                boolean datosCorrectos = conexionSQL.verificarUsuarioContrasena(user, pwd);

                if (datosCorrectos) {
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getContext(), "Usuario y/o contraseña incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}




































