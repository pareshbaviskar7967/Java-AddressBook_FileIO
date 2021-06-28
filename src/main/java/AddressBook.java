import java.io.FileNotFoundException;
import java.util.*;

public class AddressBook extends Function {
    public void displayOptions() throws FileNotFoundException {
        HashMap<String, ArrayList<Person>> addressBooks = new HashMap<String, ArrayList<Person>>();
        Scanner scanner = new Scanner(System.in);
        int option;
        int outerFlag = 0;
        while (outerFlag == 0) {
            System.out.println("Select from the following options:");
            System.out.println("1 for create new address book");
            System.out.println("2 for display all address books");
            System.out.println("3 for add person details in address book");
            System.out.println("4 for view details of an address book");
            System.out.println("0 for exit");
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Creating a new address book..");
                    System.out.println("Please provide the name for the address book: ");
                    scanner.nextLine();
                    String bookName = scanner.nextLine();
                    createBookFileTxt(bookName);
                    break;

                case 2:
                    System.out.println("Displaying all address book(s) files in the specified directory..");
                    showBookFiles();
                    break;

                case 3:
                    System.out.println("Editing records in the address book..");
                    System.out.println("Displaying all address books");
                    showBookFiles();
                    System.out.println("Select from the address books list,");
                    System.out.println("Name of address books you want to alter information in: ");
                    scanner.nextLine();
                    String addressBookName = scanner.nextLine();
                    if (fileCheck(addressBookName) == 0) {
                        System.out.println("Address book with name " + addressBookName + " does not exists.");
                        break;
                    } else if (fileCheck(addressBookName) == -1) {
                        System.out.println("Specified directory does not exists.");
                        break;
                    }
                    int choice;
                    int innerflag = 0;
                    while (innerflag == 0) {
                        System.out.println("Select from the following options:");
                        System.out.println("1 for add new person details in the address book");
                        System.out.println("2 for display list of persons in address book");
                        System.out.println("0 for exit");
                        System.out.println("Enter your choice: ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Enter first name: ");
                                String var1 = scanner.nextLine();
                                System.out.println("Enter last name: ");
                                String var2 = scanner.nextLine();
                                System.out.println("Enter address: ");
                                String var3 = scanner.nextLine();
                                System.out.println("Enter city: ");
                                String var4 = scanner.nextLine();
                                System.out.println("Enter state: ");
                                String var5 = scanner.nextLine();
                                System.out.println("Enter pin: ");
                                String var6 = scanner.nextLine();
                                System.out.println("Enter phone no: ");
                                String var7 = scanner.nextLine();
                                addPersonToFileTxt(var1, var2, var3, var4, var5, var6, var7, addressBookName);
                                break;

                            case 2:
                                getBookFileDataTxt(addressBookName);
                                break;

                            case 0:
                                innerflag = 1;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Displaying all address books");
                    showBookFiles();
                    System.out.println("Select from the address books list,");
                    System.out.println("Name of address books you want to alter information in: ");
                    scanner.nextLine();
                    String AddBookName = scanner.nextLine();
                    getBookFileDataTxt(AddBookName);
                    break;

                case 0:
                    outerFlag = 1;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the Address Book");
        AddressBook object = new AddressBook();
        object.displayOptions();
    }
}