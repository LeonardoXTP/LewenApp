package com.example.lewen.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lewen.MainActivity;
import com.example.lewen.R;
import com.example.lewen.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private ImageButton btnMascota, btnMiembro, btnMarket, btnContacto, btnConfig, btnLogout;

    private FragmentHomeBinding binding;
//    private VideoView video1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

//        video1 = root.findViewById(R.id.video1);
//        String ruta = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.video1;
//        Uri uri = Uri.parse(ruta);
//        video1.setVideoURI(uri);
//
//        MediaController media = new MediaController(getContext());
//        video1.setMediaController(media);
//        media.setAnchorView(video1);

        btnMascota = root.findViewById(R.id.btnMascota);
        btnMiembro = root.findViewById(R.id.btnMiembro);
        btnMarket = root.findViewById(R.id.btnMarket);
        btnContacto = root.findViewById(R.id.btnContacto);
        btnConfig = root.findViewById(R.id.btnConfig);
        btnLogout = root.findViewById(R.id.btnLogout);

        btnMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_nav_home_to_nav_mascotas);
            }
        });

        btnMiembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_nav_home_to_nav_miembros);
            }
        });

        btnMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_nav_home_to_nav_marketplace);
            }
        });

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_nav_home_to_nav_contacto);
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_nav_home_to_nav_configuracion);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
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