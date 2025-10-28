package Lab008;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // 1. Connect to server (same computer → localhost)
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            // 2. Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            String msgToServer, msgFromServer;

            // 3. Chat loop
            while (true) {
                System.out.print("You (Client): ");
                msgToServer = sc.nextLine();
                out.println(msgToServer);

                if (msgToServer.equalsIgnoreCase("exit")) {
                    System.out.println("Disconnected from server.");
                    break;
                }

                msgFromServer = in.readLine();
                if (msgFromServer == null) break;
                System.out.println("Server: " + msgFromServer);
            }

            // 4. Close everything
            sc.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
