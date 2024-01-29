package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNumEdad;
    EditText txtNumPeso;
    EditText txtNumEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumEdad = findViewById(R.id.txtNumEdad);
        txtNumPeso = findViewById(R.id.txtNumPeso);
        txtNumEstatura = findViewById(R.id.txtNumEstatura);
    }

    public void imc(View vista) {
        String edad = txtNumEdad.getText().toString();
        String peso = txtNumPeso.getText().toString();
        String estatura = txtNumEstatura.getText().toString();

        if (edad.equals("") || peso.equals("") || estatura.equals("")) {
            Toast.makeText(getApplicationContext(), "Por favor introduzca los datos", Toast.LENGTH_LONG).show();
        }else{
            int numEdad = Integer.parseInt(edad);
            float numPeso = Float.parseFloat(peso);
            float numEstatura = Float.parseFloat(estatura);
            numEstatura = numEstatura/100;

            // Calcular el IMC
            float imc = numPeso/(float) Math.pow(numEstatura, 2);
            // Convertir el resultado a texto
            String imcTexto = String.format("%.1f", imc);

            if (imc < 18.5f) {
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numEdad + " y su indice de masa corporal es de: " + imcTexto + " tienes un IMC bajo.", Toast.LENGTH_LONG).show();
            } else if (imc >= 18.5f && imc < 25) {
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numEdad + " y su indice de masa corporal es de: " + imcTexto + " tienes un IMC Normal.", Toast.LENGTH_LONG).show();
            }else if (imc >= 25 && imc < 30) {
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numEdad + " y su indice de masa corporal es de: " + imcTexto + " tienes un IMC con sobrepeso.", Toast.LENGTH_LONG).show();
            }else if (imc >= 30 && imc < 35) {
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numEdad + " y su indice de masa corporal es de: " + imcTexto + " tienes un IMC con obesidad I .", Toast.LENGTH_LONG).show();
            }else if (imc >= 35 && imc < 40) {
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numEdad + " y su indice de masa corporal es de: " + imcTexto + " tienes un IMC con obesidad II.", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Su edad es de: " + numEdad + " y su indice de masa corporal es de: " + imcTexto + " tienes un IMC con obesidad III.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
