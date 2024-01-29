import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new DatagramSocket();

            // Introduir el nom del client
            System.out.print("Entra el teu nom: ");
            String clientName = scanner.nextLine();
            byte[] nameData = clientName.getBytes();
            DatagramPacket namePacket = new DatagramPacket(nameData, nameData.length, InetAddress.getLocalHost(), 12345);
            socket.send(namePacket);

            while (true) {
                // Introduir el missatge
                System.out.print("Entra un missatge (o 'adeu' per desconnectar): ");
                String message = scanner.nextLine();
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getLocalHost(), 12345);
                socket.send(sendPacket);

                // Comprovació si el client vol desconnectar-se
                if (message.equalsIgnoreCase("adeu")) {
                    System.out.println("T'has desconnectat.");
                    break;
                }

                // Creació del paquet per rebre la resposta del servidor
                byte[] receivingData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receivingData, receivingData.length);
                socket.receive(receivePacket);

                // Processament de la resposta i mostrar-la
                String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Resposta del servidor: " + responseMessage);
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

