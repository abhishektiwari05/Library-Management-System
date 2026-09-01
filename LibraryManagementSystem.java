import java.util.*;

class Book {
    int id;
    String title, author;
    boolean isAvailable;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    void display() {
        System.out.println(id + " | " + title + " | " + author + " | " + (isAvailable ? "Available" : "Issued"));
    }
}

public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        // Sample books
        books.add(new Book(1, "Java Basics", "James Gosling"));
        books.add(new Book(2, "Data Structures", "Robert Lafore"));
        books.add(new Book(3, "Operating System", "Galvin"));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> addBook();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void viewBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books) b.display();
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && !b.isAvailable) {
                b.isAvailable = true;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid Book ID!");
    }
}
