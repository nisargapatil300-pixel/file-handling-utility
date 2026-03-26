import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;1

public class FileHandlingUtility {

    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "sample.txt";

    // Write to file (overwrite)
    public static void writeFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            System.out.print("Enter text to write: ");
            String data = sc.nextLine();
            fw.write(data);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read file
    public static void readFile() {
        try {
            File file = new File(FILE_NAME);
            Scanner reader = new Scanner(file);

            System.out.println("\nFile Content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please write first.");
        }
    }

    // Modify file (append)
    public static void modifyFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            System.out.print("Enter text to append: ");
            String data = sc.nextLine();
            fw.write("\n" + data);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- File Handling Menu ---");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear invalid input
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    writeFile();
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
