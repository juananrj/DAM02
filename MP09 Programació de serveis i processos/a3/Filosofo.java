package a3;


import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable {
    private int id;
    private Semaphore izquierda;
    private Semaphore derecha;

    public Filosofo(int id, Semaphore izquierda, Semaphore derecha) {
        this.id = id;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filósofo " + id + " está pensando.");
                Thread.sleep(1000); // El filósofo está pensando

                System.out.println("Filósofo " + id + " quiere comer.");
                izquierda.acquire(); // Intenta adquirir el palillo izquierdo
                derecha.acquire();   // Intenta adquirir el palillo derecho

                System.out.println("Filósofo " + id + " está comiendo.");
                Thread.sleep(1000); // El filósofo está comiendo

                System.out.println("Filósofo " + id + " ha terminado de comer.");

                izquierda.release(); // Libera el palillo izquierdo
                derecha.release();   // Libera el palillo derecho
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore[] palillos = new Semaphore[10];
        Filosofo[] filosofos = new Filosofo[10];

        for (int i = 0; i < 10; i++) {
            palillos[i] = new Semaphore(1);
        }

        for (int i = 0; i < 10; i++) {
            int izquierda = i;
            int derecha = (i + 1) % 10;
            filosofos[i] = new Filosofo(i, palillos[izquierda], palillos[derecha]);
            new Thread(filosofos[i]).start();
        }
    }
}
