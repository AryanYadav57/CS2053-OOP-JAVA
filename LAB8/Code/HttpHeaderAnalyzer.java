package Lab008;

import java.io.*;
import java.net.*;
import java.util.*;

public class HttpHeaderAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1️⃣ Get URL input from user
            System.out.print("Enter a URL (e.g., https://www.google.com): ");
            String inputUrl = sc.nextLine();
            URL url = new URL(inputUrl);

            // 2️⃣ Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 3️⃣ Display request method
            System.out.println("\n--- HTTP Header Information ---");
            System.out.println("Request Method: " + connection.getRequestMethod());

            // 4️⃣ Display response code and message
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);

            // 5️⃣ Display all header fields
            System.out.println("\n--- All HTTP Headers ---");
            Map<String, List<String>> headers = connection.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();

                if (headerName != null) {
                    System.out.println(headerName + ": " + String.join(", ", headerValues));
                } else {
                    // The first line (like HTTP/1.1 200 OK) may have a null key
                    System.out.println(String.join(", ", headerValues));
                }
            }

            connection.disconnect();
            sc.close();

        } catch (MalformedURLException e) {
            System.out.println("Error: Invalid URL format!");
        } catch (IOException e) {
            System.out.println("Error: Unable to connect or retrieve headers!");
        }
    }
}
