package Lab008;
import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylist {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Music Playlist Menu ===");
            System.out.println("1. Add Song at Beginning");
            System.out.println("2. Add Song at End");
            System.out.println("3. Remove First Song");
            System.out.println("4. Remove Last Song");
            System.out.println("5. Replace Song at Given Index");
            System.out.println("6. Display Playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline
 
            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add at beginning: ");
                    String firstSong = sc.nextLine();
                    playlist.addFirst(firstSong);
                    System.out.println("Song added at the beginning.");
                    break;

                case 2:
                    System.out.print("Enter song name to add at end: ");
                    String lastSong = sc.nextLine();
                    playlist.addLast(lastSong);
                    System.out.println("Song added at the end.");
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed song: " + playlist.removeFirst());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed song: " + playlist.removeLast());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    break;

                case 5:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty!");
                    } else {
                        System.out.print("Enter index (0 to " + (playlist.size() - 1) + "): ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        if (index >= 0 && index < playlist.size()) {
                            System.out.print("Enter new song name: ");
                            String newSong = sc.nextLine();
                            playlist.set(index, newSong);
                            System.out.println("Song replaced successfully.");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    }
                    break;

                case 6:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty!");
                    } else {
                        System.out.println("\n🎶 Current Playlist:");
                        for (int i = 0; i < playlist.size(); i++) {
                            System.out.println((i + 1) + ". " + playlist.get(i));
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
 
        } while (choice != 7);

        sc.close();
    }
}
