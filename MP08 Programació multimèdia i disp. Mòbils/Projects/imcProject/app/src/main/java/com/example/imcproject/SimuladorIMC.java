package com.example.imcproject;

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

    public double calcular(Solicitud solicitud) {
        double interes = 0;
        try {
            Thread.sleep(5000);   // simular operacion de larga duracion (10s)
            interes = 100;
        } catch (InterruptedException e) {}

        return solicitud.peso*interes/12/(1-Math.pow(1+(interes/12),-solicitud.estatura*12));
        //return solicitud.peso/(float)Math.pow(solicitud.estatura, 2);
    }
}

