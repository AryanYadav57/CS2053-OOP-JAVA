package Lab008;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WhoisClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1️⃣ Ask user for a domain name
            System.out.print("Enter domain name (e.g., example.com): ");
            String domain = sc.nextLine();

            // 2️⃣ Connect to the WHOIS server (Internic) on port 43
            Socket socket = new Socket("whois.internic.net", 43);
            System.out.println("\nConnected to whois.internic.net on port 43...");

            // 3️⃣ Send the domain name to the server
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();

            // 4️⃣ Read and display the WHOIS response
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            System.out.println("\n--- WHOIS Information for " + domain + " ---\n");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 5️⃣ Close connections
            reader.close();
            socket.close();
            sc.close();

        } catch (UnknownHostException e) {
            System.out.println("Error: Unknown host. Please check your internet connection.");
        } catch (IOException e) {
            System.out.println("Error: Unable to connect or read data from server.");
        }
    }
}
