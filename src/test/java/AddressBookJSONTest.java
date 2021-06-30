import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookJSONTest {

    ArrayList<Person> person = new ArrayList<>();

    @Test
    public void givenObject_WhenStoredInTheJson_ShouldReturn_TRUE() {
        Person records = new Person(
                "Paresh",
                "22kar",
                "Bhoite Nagar",
                "Maharashtra",
                "Paresh22kar@gmail.com",
                "8407095441",
                "425001"
        );
        AddressBookJSON jsonfile = new AddressBookJSON();
        boolean isAdded = jsonfile.jsonWriteData(records);
        Assert.assertTrue(isAdded);
    }

    @Test
    public void givenJsonFile_WhenReadData_ShouldReturn_TRUE() {
        AddressBookJSON jsonfile = new AddressBookJSON();
        boolean isRead = jsonfile.jsonReadData();
        Assert.assertTrue(isRead);
    }
}