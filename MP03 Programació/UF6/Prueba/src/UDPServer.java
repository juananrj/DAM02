import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(12345);
            System.out.println("Servidor UDP en línea. Esperando conexiones...");

            while (true) {
                // Creación del paquete para recibir los datos
                byte[] receivingData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receivingData, receivingData.length);
                socket.receive(receivePacket);

                // Procesamiento del mensaje recibido
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Mensaje recibido del cliente: " + message);

                // Comprobación si el cliente envía "adeu"
                if (message.equalsIgnoreCase("adeu")) {
                    System.out.println("El cliente se ha desconectado.");
                    continue;
                }

                // Convertir el mensaje a mayúsculas
                String responseMessage = message.toUpperCase();

                // Enviar la respuesta al cliente
                byte[] sendingData = responseMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendingData, sendingData.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
