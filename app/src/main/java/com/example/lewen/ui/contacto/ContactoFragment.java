package com.example.lewen.ui.contacto;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lewen.R;

public class ContactoFragment extends Fragment {

    private ContactoViewModel mViewModel;
    private static final int REQUEST_CALL_PERMISSION = 1;
    private Button btnLlamar, btnMensaje;
    public static ContactoFragment newInstance() {
        return new ContactoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacto, container, false);

        btnLlamar = view.findViewById(R.id.btnLlamar);
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(requireContext(),
                        android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    realizarLlamada();
                } else {
                    requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE},
                            REQUEST_CALL_PERMISSION);
                }
            }
        });

        btnMensaje = view.findViewById(R.id.btnMensaje);
        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Mensaje enviado", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public void realizarLlamada() {
        String numTelf = "623590056";
        Uri number = Uri.parse("tel:" + numTelf);
        Intent intent = new Intent(Intent.ACTION_CALL, number);

        try {
            startActivity(intent);
        } catch (SecurityException e) {
            Toast.makeText(requireContext(), "Permiso denegado para realizar llamadas telefónicas",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                realizarLlamada();
            } else {
                Toast.makeText(requireContext(), "Permiso denegado para realizar llamadas telefónicas",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}