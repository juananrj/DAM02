package a3;



import java.util.concurrent.Semaphore;

class BarberoDurmiente {
    private static final int N = 5; // Número total de sillas
    private static Semaphore barberoListo = new Semaphore(0); // Mutex para el barbero
    private static Semaphore sillasAccesibles = new Semaphore(1); // Mutex para las sillas
    private static Semaphore clientes = new Semaphore(0); // Número de clientes en espera
    private static int sillasLibres = N; // Inicialmente todas las sillas están libres

    public static void main(String[] args) {
        Thread barberoThread = new Thread(BarberoDurmiente::barbero);
        Thread clienteThread = new Thread(BarberoDurmiente::cliente);

        barberoThread.start();
        clienteThread.start();
    }

    static void barbero() {
        while (true) {
            try {
                clientes.acquire(); // Espera a que un cliente lo despierte
                sillasAccesibles.acquire(); // Espera señal para modificar sillasLibres
                sillasLibres++; // Aumenta el número de sillas libres
                barberoListo.release(); // El barbero está listo para cortar
                System.out.println("Barbero: ¡Listo para cortar!");
                // Aquí el barbero corta el pelo (zona no crítica)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void cliente() {
        try {
            sillasAccesibles.acquire(); // Espera señal para acceder a sillasLibres
            if (sillasLibres > 0) {
                sillasLibres--; // Decrementa el número de sillas libres
                clientes.release(); // Hay un cliente disponible
                sillasAccesibles.release(); // Desbloquea el acceso a sillasLibres
                barberoListo.acquire(); // Espera a que el barbero esté listo
                System.out.println("Cliente: ¡Cortándome el pelo!");
                // Se corta el pelo al cliente
            } else {
                sillasAccesibles.release(); // Desbloquea el acceso a sillasLibres
                System.out.println("Cliente: No hay sillas libres. Me voy.");
                // No hay sillas libres
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
