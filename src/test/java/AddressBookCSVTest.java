import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookCSVTest {
    ArrayList<Person> person = new ArrayList<>();

    @Test
    public void givenCSVFile_WhenRead_ShouldReturn_True() throws IOException {
        AddressBookCSV openCSVReader = new AddressBookCSV();
        Boolean result = openCSVReader.readCSV();
        Assert.assertTrue(result);
    }

    @Test
    public void givenCSVFile_WhenWritten_ShouldReturn_True() throws IOException {
        String ADDRESS_BOOK_CSV_FILE_PATH = "C:\\Users\\pares\\eclipse-workspace\\Java-AddressBook-FileIO";
        List<String[]> records = new ArrayList<>();
        String[] person1 = {
                "Paresh",
                "Baviskar",
                "Sagar park",
                "Maharashtra",
                "paresh123@gmail.com",
                "8406095441",
                "425001"
        };

        String[] person2 = {
                "Pratham",
                "Baviskar",
                "MN park",
                "Maharashtra",
                "pratham123@gmail.com",
                "9552495055",
                "425201"
        };

        String[] person3 = {
                "Chetan",
                "Baviskar",
                "Borivali",
                "Maharashtra",
                "chetan123@gmail.com",
                "8482809097",
                "400101"
        };

        records.add(person1);
        records.add(person2);
        records.add(person3);

        AddressBookCSV openCSVReader = new AddressBookCSV();
        Boolean result = openCSVReader.writeCSV(records);
        Assert.assertTrue(result);
    }
}