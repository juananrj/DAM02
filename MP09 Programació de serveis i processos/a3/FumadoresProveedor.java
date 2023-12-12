package a3;

import java.util.concurrent.Semaphore;

public class FumadoresProveedor {
    // Semáforos para representar los ingredientes y garantizar la sincronización
    private Semaphore[] ingredientes = new Semaphore[3];
    // Semáforo de exclusión mutua para garantizar el acceso seguro a la mesa
    private Semaphore mutex = new Semaphore(1);

    public FumadoresProveedor() {
        for (int i = 0; i < 3; i++) {
            ingredientes[i] = new Semaphore(0); // Inicialmente, los ingredientes no están disponibles
        }
    }

    // El proveedor coloca ingredientes en la mesa
    public void proveedor() throws InterruptedException {
        while (true) {
            // El proveedor coloca dos ingredientes aleatorios en la mesa
            int ingrediente1 = (int) (Math.random() * 3);
            int ingrediente2;
            do {
                ingrediente2 = (int) (Math.random() * 3);
            } while (ingrediente1 == ingrediente2);

            mutex.acquire(); // Garantiza exclusión mutua para acceder a la mesa
            ingredientes[ingrediente1].release(); // Libera el primer ingrediente
            ingredientes[ingrediente2].release(); // Libera el segundo ingrediente
            mutex.release(); // Libera el acceso a la mesa

            // Simula el tiempo que toma al proveedor colocar los ingredientes
            Thread.sleep(2000);

            // Imprime un mensaje para indicar qué ingredientes se colocaron en la mesa
            System.out.println("Proveedor colocó ingredientes: " + ingrediente1 + " y " + ingrediente2);
        }
    }

    // Los fumadores toman ingredientes y fuman
    public void fumador(int id) throws InterruptedException {
        while (true) {
            ingredientes[id].acquire(); // Espera hasta que el fumador tenga los ingredientes necesarios

            // Imprime un mensaje cuando el fumador tiene los ingredientes y se dispone a fumar
            System.out.println("Fumador " + id + " tiene ingredientes y se dispone a fumar.");

            // Simula el tiempo que toma al fumador "liarse" un cigarrillo y fumar
            Thread.sleep(2000);

            // Imprime un mensaje cuando el fumador ha terminado de fumar y se fuma el cigarrillo
            System.out.println("Fumador " + id + " Se fuma el cigarrillo.");

            // Simula el tiempo que toma al fumador fumar el cigarrillo antes de liberar la mesa
            Thread.sleep(2000);

            mutex.release(); // Libera la mesa para que otro fumador pueda usarla
        }
    }

    public static void main(String[] args) {
        FumadoresProveedor sistema = new FumadoresProveedor();

        // Crear un hilo para el proveedor
        Thread proveedorThread = new Thread(() -> {
            try {
                sistema.proveedor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Crear hilos para los fumadores
        Thread[] fumadoresThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int id = i;
            fumadoresThreads[i] = new Thread(() -> {
                try {
                    sistema.fumador(id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Iniciar el hilo del proveedor
        proveedorThread.start();

        // Iniciar los hilos de los fumadores
        for (int i = 0; i < 3; i++) {
            fumadoresThreads[i].start();
        }
    }
}
