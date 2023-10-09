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

import com.example.fragments.databinding.FragmentOnboarding0Binding;


public class Onboarding0Fragment extends Fragment {

    private FragmentOnboarding0Binding binding;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentOnboarding0Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.botonSiguiente.setOnClickListener(view1 -> navController.navigate(R.id.action_onboarding0Fragment_to_onboarding1Fragment));

        binding.botonFinalizar.setOnClickListener(view12 -> navController.navigate(R.id.action_onboarding0Fragment_to_homeFragment));
    }

}
