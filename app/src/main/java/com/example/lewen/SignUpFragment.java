package com.example.lewen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpFragment extends Fragment {
    private EditText edtxtUserR, edtxtEmailR, edtxtPwdR, edtxtPwd2R;
    private Button btnIniciar;

    private ConexionSQL conexionSQL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        edtxtUserR = view.findViewById(R.id.edtxtUserR);
        edtxtEmailR = view.findViewById(R.id.edtxtEmailR);
        edtxtPwdR = view.findViewById(R.id.edtxtPwdR);
        edtxtPwd2R = view.findViewById(R.id.edtxtPwd2R);
        btnIniciar = view.findViewById(R.id.btnIniciar);
        conexionSQL = new ConexionSQL(getContext());

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edtxtUserR.getText().toString();
                String pwd = edtxtPwdR.getText().toString();
                String pwd2 = edtxtPwd2R.getText().toString();

                if (user.equals("") || pwd.equals("") || pwd2.equals("")) {
                    Mensaje("No puede dejar campos vacíos");
                    return;
                } if (!pwd.equals(pwd2)) {
                    Mensaje("Las contraseñas no coinciden");
                    return;
                } if (conexionSQL.verificarUsuario(user)) {
                    Mensaje("El usuario ya existe");
                    return;
                } if (conexionSQL.insertValues(user, pwd)) {
                    Mensaje("Usuario registrado correctamente");
                } else {
                    Mensaje("El registro de usuario ha fallado");
                }
            }
        });
        return view;
    }

    private void Mensaje(String msj) {
        Toast.makeText(getContext(), msj, Toast.LENGTH_SHORT).show();
    }
}