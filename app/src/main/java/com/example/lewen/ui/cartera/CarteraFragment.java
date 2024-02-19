package com.example.lewen.ui.cartera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lewen.R;
import com.example.lewen.TarjetaCredito;
import com.example.lewen.databinding.FragmentCarteraBinding;
import com.example.numpad.NumPad;
import com.example.numpad.NumPadClick;
import com.example.numpad.numPadClickListener;

import java.util.ArrayList;

public class CarteraFragment extends Fragment {
    private LinearLayout linearLay1, linearLay2;
    private Button btnPIN, btnAgregarTar;
    private NumPad numpad;
    private EditText edtxtPIN;

    private FragmentCarteraBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CarteraViewModel carteraViewModel =
                new ViewModelProvider(this).get(CarteraViewModel.class);

        binding = FragmentCarteraBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtCartera;
        carteraViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        linearLay1 = root.findViewById(R.id.linearLay1);
        linearLay2 = root.findViewById(R.id.linearLay2);
        numpad = root.findViewById(R.id.numpad);
        btnPIN = root.findViewById(R.id.btnPIN);
        btnAgregarTar = root.findViewById(R.id.btnAgregarTar);
        edtxtPIN = root.findViewById(R.id.edtxtPIN);

        // EditText edtxtNumTar = root.findViewById(R.id.edtxtNumTar);
        // ImageView img = root.findViewById(R.id.img);

        // edtxtNumTar.addTextChangedListener(new TarjetaCredito(edtxtNumTar, img));
        // Repetir para la fecha

        numpad.setOnNumPadClickListener(new NumPadClick(new numPadClickListener() {
            @Override
            public void onNumpadClicked(ArrayList<Integer> nums) {
                StringBuilder builder = new StringBuilder();

                for (int a = 0; a < nums.size(); a++) {
                    int num = nums.get(a);
                    builder.append(num);
                }
                String numeros = builder.toString();
                edtxtPIN.setText(numeros);
            }
        }));

        btnPIN = root.findViewById(R.id.btnPIN);
        btnPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pinIngresado = edtxtPIN.getText().toString();
                if (pinIngresado.equals("1234")) {
                    linearLay1.setVisibility(View.INVISIBLE);
                    linearLay2.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getContext(), "PIN incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAgregarTar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Tarjeta agregada correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}