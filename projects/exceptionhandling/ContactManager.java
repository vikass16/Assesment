
package projects.exceptionhandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A Project for add, search, update, delete and show contacts.
public class ContactManager {

    public static final String FILE_NAME = "contact.txt";

    public static void main(String[] args) {

        initializeFile();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add and save contact");
            System.out.println("2. Search contact");
            System.out.println("3. Delete contact");
            System.out.println("4. View All contact");
            System.out.println("5. Exit");
            System.out.print("Enter any number of your choice between 1 to 5: ");

            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter contact name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter contact number: ");
                        String number = sc.nextLine().trim();

                        addContact(name, number);
                        break;

                    case "2":
                        System.out.print("Enter name to be searched: ");
                        String name1 = sc.nextLine().trim();

                        searchContact(name1);
                        break;

                    case "3":
                        System.out.print("Enter name to delete: ");
                        String name2 = sc.nextLine().trim();

                        deleteContact(name2);
                        break;

                    case "4":
                        displayAllContacts();
                        break;

                    case "5":
                        running = false;
                        System.out.println("Exiting Program!!");
                        break;

                    default:
                        System.out.println("Invalid Choice!!");
                }

            } catch (ContactException e) {
                System.out.println("Contact Error: " + e.getMessage());

            } catch (IOException e) {
                System.out.println("File I/O Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Unexpected Exception: " + e.getMessage());
            }
        }

        sc.close();
    }

    // Creating a new file if it does not already exist
    public static void initializeFile() {
        File file = new File(FILE_NAME);

        try {
            if (file.createNewFile()) {
                System.out.println("New File Created: " + file.getName());
            }
        } catch (IOException e) {
            System.err.println("Failed to Initialize file: " + e.getMessage());
        }
    }

    // Appending contact info to the txt file
    public static void addContact(String name, String number)
            throws ContactException, IOException {

        name = name.trim();
        number = number.trim();

        if (name.isEmpty() || number.isEmpty()) {
            throw new ContactException(
                    "Name and Number cannot be blank.");
        }

        if (name.contains(",") || number.contains(",")) {
            throw new ContactException(
                    "Contact name and number must not contain commas.");
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(name + "," + number);
            writer.newLine();

            System.out.println("Contact saved successfully.");
        }
    }

    // Searching contact in txt file or Contact list
    public static void searchContact(String name)
            throws ContactException, IOException {

        name = name.trim();

        if (name.isEmpty()) {
            throw new ContactException(
                    "Search name cannot be empty.");
        }

        boolean found = false;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length == 2
                        && parts[0].trim().equalsIgnoreCase(name)) {

                    System.out.println("--> Contact found: "
                            + parts[0] + " Number: " + parts[1]);

                    found = true;
                    // No break: display every matching contact.
                }
            }
        }

        if (!found) {
            throw new ContactException(
                    "No contact found with this name: " + name);
        }
    }

    // Delete contact
    public static void deleteContact(String name)
            throws ContactException, IOException {

        name = name.trim();

        if (name.isEmpty()) {
            throw new ContactException(
                    "Delete term cannot be empty.");
        }

        List<String> retainedLines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (!found
                        && parts.length == 2
                        && parts[0].trim().equalsIgnoreCase(name)) {

                    found = true;
                    // Skip only the first matching contact.

                } else {
                    retainedLines.add(line);
                }
            }
        }

        if (!found) {
            throw new ContactException(
                    "Cannot delete: Contact " + name + " does not exist.");
        }

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(FILE_NAME, false))) {

            for (String record : retainedLines) {
                bufferedWriter.write(record);
                bufferedWriter.newLine();
            }
        }

        System.out.println(
                "Contact '" + name + "' Deleted Successfully!!");
    }

    // Displaying All Stored Contacts.
    public static void displayAllContacts() throws IOException {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            int count = 0;

            System.out.println("\n--- All Saved Contacts ---");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length == 2) {
                    System.out.println(
                            ++count + ". " + parts[0] + " --> " + parts[1]);
                }
            }

            if (count == 0) {
                System.out.println("No contacts stored yet!");
            }
        }
    }
}
