package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.databinding.FragmentOnboarding1Binding;
import com.example.fragments.databinding.FragmentOnboarding2Binding;
import com.example.fragments.databinding.FragmentOnboarding3Binding;


public class Onboarding3Fragment extends Fragment {

    private FragmentOnboarding3Binding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_onboarding2, container, false);
        return (binding = FragmentOnboarding3Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.botonSiguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_onboarding3Fragment_to_onboarding1Fragment2);
            }
        });

        binding.skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_onboarding3Fragment_to_homeFragment2);
            }
        });
    }
}