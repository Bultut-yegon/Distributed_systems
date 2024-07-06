package Java_Socket_programming;
// public class UDPClient {
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Create a socket
            socket = new DatagramSocket();

            // The server address and port to send the data to
            InetAddress serverAddress = InetAddress.getByName("172.16.98.247"); // Replace with the actual server IP address
            int serverPort = 1234;

            System.out.println("Enter messages to send to the server (type 'exit' to quit):");

            while (true) {
                // Read user input
                String message = scanner.nextLine();

                // Exit the loop if the user types 'exit'
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                // Convert the message to bytes
                byte[] sendBuffer = message.getBytes();

                // Create a packet to send data
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

                // Send the packet
                socket.send(sendPacket);

                // Optional: Receive a response from the server (if desired)
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                // Print the response from the server
                String responseData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Response from server: " + responseData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}
    

