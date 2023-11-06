package com.example.p1multicontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.p1multicontador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int contador1 = 0;
    int contador2 = 0;
    int contador3 = 0;
    int contador4 = 0;

    ActivityMainBinding binding;

    private void actualizarSumaTotal() {
        int contador_total = contador1+contador2+contador3+contador4;
        // Actualiza el textview contador_total con la nueva suma
        binding.textViewResetAll.setText(contador_total+"");
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


        binding.masUno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador1++;
                //mostrar el contador en el textview
                binding.textViewReset1.setText(contador1+"");
                actualizarSumaTotal();
            }
        });

        binding.masUno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador2++;
                //mostrar el contador en el textview
                binding.textViewReset2.setText(contador2+"");
                actualizarSumaTotal();
            }
        });

        binding.masUno3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador3++;
                //mostrar el contador en el textview
                binding.textViewReset3.setText(contador3+"");
                actualizarSumaTotal();
            }
        });

        binding.masUno4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador4++;
                //mostrar el contador en el textview
                binding.textViewReset4.setText(contador4+"");
                actualizarSumaTotal();
            }
        });


        binding.reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador1 = 0;
                //aumentar el contador
                binding.textViewReset1.setText(contador1+"");
                actualizarSumaTotal();
            }
        });

        binding.reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador2 = 0;
                //aumentar el contador
                binding.textViewReset2.setText(contador2+"");
                actualizarSumaTotal();
            }
        });

        binding.reset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador3 = 0;
                //aumentar el contador
                binding.textViewReset3.setText(contador3+"");
                actualizarSumaTotal();
            }
        });

        binding.reset4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aumentar el contador
                contador4 = 0;
                //aumentar el contador
                binding.textViewReset4.setText(contador4+"");
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
                binding.textViewReset1.setText(contador1+"");
                binding.textViewReset2.setText(contador2+"");
                binding.textViewReset3.setText(contador3+"");
                binding.textViewReset4.setText(contador4+"");
                actualizarSumaTotal();
            }
        });
    }
}