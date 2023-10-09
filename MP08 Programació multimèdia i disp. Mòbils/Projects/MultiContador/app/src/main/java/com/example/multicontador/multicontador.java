package com.example.multicontador;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.multicontador.databinding.ActivityMainBinding;

public class multicontador extends AppCompatActivity {
    int contador1 = 0;
    int contador2 = 0;
    int contador3 = 0;
    int contador4 = 0;

    ActivityMainBinding binding;

    private void actualizarSumaTotal() {
        int contador_total = contador1+contador2+contador3+contador4;
        // Actualiza el textview contador_total con la nueva suma
        binding.resetAll.setText(contador_total+"");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        contador1 = 0;
        contador2 = 0;
        contador3 = 0;
        contador4 = 0;


        binding.contador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador1++;
                //mostrar el contador en el textview
                binding.reset1.setText(contador1+"");
                actualizarSumaTotal();
            }
        });

        binding.contador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador2++;
                //mostrar el contador en el textview
                binding.reset2.setText(contador2+"");
                actualizarSumaTotal();
            }
        });

        binding.contador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador3++;
                //mostrar el contador en el textview
                binding.reset3.setText(contador3+"");
                actualizarSumaTotal();
            }
        });

        binding.contador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador4++;
                //mostrar el contador en el textview
                binding.reset4.setText(contador4+"");
                actualizarSumaTotal();
            }
        });


        binding.reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador1 = 0;
                //aumentar el contador
                binding.reset1.setText(contador1+"");
                actualizarSumaTotal();
            }
        });

        binding.reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador2 = 0;
                //aumentar el contador
                binding.reset2.setText(contador2+"");
                actualizarSumaTotal();
            }
        });

        binding.reset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador3 = 0;
                //aumentar el contador
                binding.reset3.setText(contador3+"");
                actualizarSumaTotal();
            }
        });

        binding.reset4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador4 = 0;
                //aumentar el contador
                binding.reset4.setText(contador4+"");
                actualizarSumaTotal();
            }
        });
        binding.resetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador1 = 0;
                contador2 = 0;
                contador3 = 0;
                contador4 = 0;
                //aumentar el contador
                binding.reset1.setText(contador1+"");
                binding.reset2.setText(contador2+"");
                binding.reset3.setText(contador3+"");
                binding.reset4.setText(contador4+"");
                actualizarSumaTotal();
            }
        });
    }
}
