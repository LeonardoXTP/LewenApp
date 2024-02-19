package com.example.lewen.ui.masinfo;

import androidx.lifecycle.ViewModelProvider;

import android.animation.LayoutTransition;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lewen.R;
import com.example.lewen.databinding.FragmentMasinfoBinding;

public class MasInfoFragment extends Fragment {

    private FragmentMasinfoBinding binding;
    private LinearLayout layoutOculto1, layoutOculto2, layoutOculto3, layoutOculto4, layoutOculto5, layoutOculto6, layoutOculto7, layoutOculto8;
    private LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MasInfoViewModel masInfoViewModel =
                new ViewModelProvider(this).get(MasInfoViewModel.class);

        binding = FragmentMasinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        masInfoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        layoutOculto1 = root.findViewById(R.id.layoutOculto1);
        layoutOculto2 = root.findViewById(R.id.layoutOculto2);
        layoutOculto3 = root.findViewById(R.id.layoutOculto3);
        layoutOculto4 = root.findViewById(R.id.layoutOculto4);
        layoutOculto5 = root.findViewById(R.id.layoutOculto5);
        layoutOculto6 = root.findViewById(R.id.layoutOculto6);
        layoutOculto7 = root.findViewById(R.id.layoutOculto7);
        layoutOculto8 = root.findViewById(R.id.layoutOculto8);

        layout1 = root.findViewById(R.id.layout1);
        layout2 = root.findViewById(R.id.layout2);
        layout3 = root.findViewById(R.id.layout3);
        layout4 = root.findViewById(R.id.layout4);
        layout5 = root.findViewById(R.id.layout5);
        layout6 = root.findViewById(R.id.layout6);
        layout7 = root.findViewById(R.id.layout7);
        layout8 = root.findViewById(R.id.layout8);

        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout4.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout5.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout6.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout7.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout8.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);


        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir1(v);
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir2(v);
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir3(v);
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir4(v);
            }
        });

        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir5(v);
            }
        });

        layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir6(v);
            }
        });

        layout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir7(v);
            }
        });

        layout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandir8(v);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void expandir1(View view) {
        int visible1 = (layoutOculto1.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
        layoutOculto1.setVisibility(visible1);
    }

    public void expandir2(View view) {
        int visible1 = (layoutOculto2.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
        layoutOculto2.setVisibility(visible1);
    }

    public void expandir3(View view) {
        int visible1 = (layoutOculto3.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
        layoutOculto3.setVisibility(visible1);
    }

    public void expandir4(View view) {
        int visible1 = (layoutOculto4.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout4, new AutoTransition());
        layoutOculto4.setVisibility(visible1);
    }

    public void expandir5(View view) {
        int visible1 = (layoutOculto5.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout5, new AutoTransition());
        layoutOculto5.setVisibility(visible1);
    }

    public void expandir6(View view) {
        int visible1 = (layoutOculto6.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout6, new AutoTransition());
        layoutOculto6.setVisibility(visible1);
    }

    public void expandir7(View view) {
        int visible1 = (layoutOculto7.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout7, new AutoTransition());
        layoutOculto7.setVisibility(visible1);
    }

    public void expandir8(View view) {
        int visible1 = (layoutOculto8.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout8, new AutoTransition());
        layoutOculto8.setVisibility(visible1);
    }
}