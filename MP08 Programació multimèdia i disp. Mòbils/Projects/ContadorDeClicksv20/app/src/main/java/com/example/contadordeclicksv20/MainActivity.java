package com.example.contadordeclicksv20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.contadordeclicksv20.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    int contador;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());
        binding.augmentarElContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                binding.contadorDeClics.setText("Has clicado " + contador + " veces");
            }
        });
    }
}