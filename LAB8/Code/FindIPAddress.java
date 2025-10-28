package Lab008;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FindIPAddress {
    public static void main(String[] args) {
        try {
            // 1️⃣ Display your computer’s IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Your Computer Host Name: " + localHost.getHostName());
            System.out.println("Your Computer IP Address: " + localHost.getHostAddress());

            // 2️⃣ Accept a domain name
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter a domain name (e.g., www.google.com): ");
            String domain = sc.nextLine();

            // 3️⃣ Print all IP addresses of that domain
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("\nIP Addresses of " + domain + ":");
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }

            sc.close();

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to find IP address. Please check the domain name!");
        }
    }
}