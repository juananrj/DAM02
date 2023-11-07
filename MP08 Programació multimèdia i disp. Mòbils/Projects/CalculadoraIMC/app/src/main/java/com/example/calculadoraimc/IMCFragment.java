package com.example.calculadoraimc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculadoraimc.databinding.FragmentIMCBinding;

public class IMCFragment extends Fragment {
    private FragmentIMCBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentIMCBinding.inflate(inflater, container, false)).getRoot();

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int edad = Integer.parseInt(binding.txtNumEdad.getText().toString());
                float peso = Float.parseFloat(binding.txtNumPeso.getText().toString());
                float estatura = Float.parseFloat(binding.txtNumEstatura.getText().toString());

                SimuladorIMC.Solicitud solicitud = new SimuladorIMC.Solicitud(edad, peso, estatura);

                new AsyncTask<SimuladorIMC.Solicitud, Void, Float>(){

                    @Override
                    protected Float doInBackground(SimuladorIMC.Solicitud... solicitudes) {
                        SimuladorIMC simulador = new SimuladorIMC();
                        return simulador.calcular(solicitudes[0]);
                    }

                    @Override
                    protected void onPostExecute(Float cuota) {
                        super.onPostExecute(cuota);

                        binding.cuota.setText(String.format("%.2f",cuota));
                    }
                }.execute(solicitud);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}