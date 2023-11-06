package com.example.calculadoraimc;

public class SimuladorIMC {

    public static class Solicitud {

        public int edad;
        public float peso;
        public float estatura;

        public Solicitud(int edad, float peso, float estatura) {
            this.edad = edad;
            this.peso = peso;
            this.estatura = estatura;
        }
    }

    public float calcular(Solicitud solicitud) {
        try {
            Thread.sleep(5000);   // simular operacion de larga duracion (10s)
        } catch (InterruptedException e) {}

        return solicitud.peso/(float) Math.pow(solicitud.estatura, 2);

    }
}