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
        String ADDRESS_BOOK_CSV_FILE_PATH = "C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources";
        List<String[]> records = new ArrayList<>();
        String[] person1 = {
                "Atharva",
                "Joshi",
                "Sagar park",
                "Maharashtra",
                "atharva@email",
                "9665654666",
                "425201"
        };

        String[] person2 = {
                "Gaurav",
                "Joshi",
                "MN park",
                "Maharashtra",
                "gaurav@email",
                "9552495055",
                "425201"
        };

        String[] person3 = {
                "Piyush",
                "Joshi",
                "BL Farms",
                "Maharashtra",
                "piyush@email",
                "8482809097",
                "425201"
        };

        records.add(person1);
        records.add(person2);
        records.add(person3);

        AddressBookCSV openCSVReader = new AddressBookCSV();
        Boolean result = openCSVReader.writeCSV(records);
        Assert.assertTrue(result);
    }
}