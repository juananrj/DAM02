package com.example.imcproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imcproject.databinding.FragmentIMCBinding;

public class IMCFragment extends Fragment {
    private FragmentIMCBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentIMCBinding.inflate(inflater, container, false)).getRoot();

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimuladorIMC simuladorIMC = new SimuladorIMC();

                int edad = Integer.parseInt(binding.textEdad.getText().toString());
                float peso = Float.parseFloat(binding.peso.getText().toString());
                float estatura = Float.parseFloat(binding.estatura.getText().toString());

                SimuladorIMC.Solicitud solicitud = new SimuladorIMC.Solicitud(edad, peso, estatura);

                double cuota = simuladorIMC.calcular(solicitud);

                binding.cuota.setText(String.format("%.2f",cuota));
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}