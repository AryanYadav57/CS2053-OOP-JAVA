package Lab008;

import java.io.*;
import java.net.*;
import java.util.*;

public class WebsiteInfoViewer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1️⃣ Get URL from user
            System.out.print("Enter a website URL (e.g., https://www.google.com): ");
            String inputUrl = sc.nextLine();

            // 2️⃣ Create URL and URLConnection object
            URL url = new URL(inputUrl);
            URLConnection connection = url.openConnection();

            // 3️⃣ Display URL details
            System.out.println("\n--- Website Information ---");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Content Type: " + connection.getContentType());

            long date = connection.getDate();
            if (date != 0)
                System.out.println("Date: " + new Date(date));
            else
                System.out.println("Date: Not available");

            int length = connection.getContentLength();
            if (length != -1)
                System.out.println("Content Length: " + length + " bytes");
            else
                System.out.println("Content Length: Not available");

            // 4️⃣ Display first few lines of webpage content
            System.out.println("\n--- First Few Lines of Content ---");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            int count = 0;
            while ((line = br.readLine()) != null && count < 5) { // show first 5 lines
                System.out.println(line);
                count++;
            }

            br.close();
            sc.close();

        } catch (MalformedURLException e) {
            System.out.println("Error: Invalid URL format!");
        } catch (IOException e) {
            System.out.println("Error: Unable to connect to the website!");
        }
    }
}
