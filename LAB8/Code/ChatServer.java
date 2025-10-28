package Lab008;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            // 1. Create server socket to listen on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client connection...");

            // 2. Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // 3. Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 4. Read messages from client and send replies
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String msgFromClient, msgToClient;

            while (true) {
                msgFromClient = in.readLine();
                if (msgFromClient == null || msgFromClient.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + msgFromClient);

                System.out.print("You (Server): ");
                msgToClient = keyboard.readLine();
                out.println(msgToClient);
            }

            // 5. Close connections
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
 