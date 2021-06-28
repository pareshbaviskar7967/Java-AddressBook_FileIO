import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Function {

    ArrayList<Person> records = new ArrayList<Person>();

    public int fileCheck(String bookName) {
        File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
        if (!directory.exists()) {
            return -1;
        } else {
            String fileName = bookName;
            File myTxtFile = new File(directory, fileName + ".txt");
            if (myTxtFile.exists()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public void createBookFileTxt(String bookName) {
        try {
            File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
            if (!directory.exists()) {
                directory.mkdir();
            }
            String fileName = bookName;
            File myTxtFile = new File(directory, fileName + ".txt");
            if (!myTxtFile.exists()) {
                myTxtFile.createNewFile();
                System.out.println("New address book is created with name: " + myTxtFile.getName());
            } else {
                System.out.println("Address book with name " + myTxtFile.getName() + " is already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeBookFileTxt(String bookName, Person person) {
        try {
            File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
            if (!directory.exists()) {
                System.out.println("Specified directory does not exists.");
            } else {
                String fileName = bookName;
                File myTxtFile = new File(directory, fileName + ".txt");
                if (myTxtFile.exists()) {
                    FileWriter myWriter = new FileWriter(myTxtFile, true);
                    BufferedWriter myBuffer = new BufferedWriter(myWriter);
                    myBuffer.write(person.toString());
                    myBuffer.close();
                    System.out.println("Data successfully wrote to the file.");
                } else {
                    System.out.println("Address book with name " + myTxtFile.getName() + " does not exists.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addPersonToFileTxt(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String addressBookName) {
        Person personObj = new Person(firstName, lastName, phoneNumber, address, city, state, zip);
        int result = personObj.findPhoneNo(records, phoneNumber);
        if (result != -1) {
            System.out.println("The address book already has details with " + phoneNumber + " this phone number.");
        } else {
            records.add(personObj);
            writeBookFileTxt(addressBookName, personObj);
            System.out.println();
            System.out.println("Information added successfully.\n");
        }
    }

    public void showBookFiles() {
        File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
        if (directory.exists()) {
            File filesList[] = directory.listFiles();
            System.out.println("List of files in the specified directory (./resources):");
            for (File file : filesList) {
                System.out.println("File name: " + file.getName());
                System.out.println();
            }
        } else {
            System.out.println("Specified directory does not exists.");
        }
    }

    public void getBookFileDataTxt(String bookName) throws FileNotFoundException {
        File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
        String fileName = bookName;
        File myTxtFile = new File(directory, fileName + ".txt");
        if (myTxtFile.exists()) {
            Scanner myReader = new Scanner(myTxtFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } else {
            System.out.println("Address book with name " + myTxtFile.getName() + " is not exists.");
        }
    }
}