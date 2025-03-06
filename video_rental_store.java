import java.util.ArrayList;
import java.util.Scanner;

// Video class to hold video details
class Video{
    private String title;
    private boolean isRented;

    public Video(String title) {
        this.title = title;
        this.isRented = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentVideo() {
        if (!isRented) {
            isRented = true;
            System.out.println(title + " has been rented.");
        } else {
            System.out.println(title + " is already rented.");
        }
    }

    public void returnVideo() {
        if (isRented) {
            isRented = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not rented.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Rented: " + (isRented ? "Yes" : "No");
    }
}

// VideoStore class to manage the inventory
class VideoStore {
    private ArrayList<Video> inventory;

    public VideoStore() {
        inventory = new ArrayList<>();
    }

    public void addVideo(String title) {
        inventory.add(new Video(title));
        System.out.println(title + " has been added to the inventory.");
    }

    public void removeVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                inventory.remove(video);
                System.out.println(title + " has been removed from the inventory.");
                return;
            }
        }
        System.out.println(title + " not found in the inventory.");
    }

    public void rentVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                video.rentVideo();
                return;
            }
        }
        System.out.println(title + " not found in the inventory.");
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                video.returnVideo();
                return;
            }
        }
        System.out.println(title + " not found in the inventory.");
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Video video : inventory) {
                System.out.println(video);
            }
        }
    }
}

// Main class to run the application
class video_rental_store {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Video Rental Store ---");
            System.out.println("1. Add Video");
            System.out.println("2. Remove Video");
            System.out.println("3. Rent Video");
            System.out.println("4. Return Video");
            System.out.println("5. Display Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter video title to add: ");
                    String addTitle = scanner.nextLine();
                    store.addVideo(addTitle);
                    break;
                case 2:
                    System.out.print("Enter video title to remove: ");
                    String removeTitle = scanner.nextLine();
                    store.removeVideo(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter video title to rent: ");
                    String rentTitle = scanner.nextLine();
                    store.rentVideo(rentTitle);
                    break;
                case 4:
                    System.out.print("Enter video title to return: ");
                    String returnTitle = scanner.nextLine();
                    store.returnVideo(returnTitle);
                    break;
                case 5:
                    store.displayInventory();
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
