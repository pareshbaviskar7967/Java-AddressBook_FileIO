import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddressBookJSON {
    private static final String HOME = System.getProperty("user.dir");
    private static final String fileName = "AddressBookJSON.json";
    private static final Path homePath = Paths.get(HOME);

    private static final Gson gson = new GsonBuilder().create();

    public boolean jsonWriteData(Person personInfo) {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {

                if (Files.exists(filePath)) {
                    String s = gson.toJson(personInfo);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                } else {
                    Files.createFile(filePath);
                    String s = gson.toJson(personInfo);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public boolean jsonReadData() {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)));
                    Person personReader = gson.fromJson(br, Person.class);
                    System.out.println("personReader{" +
                            "  First name = '" + personReader.firstName + '\'' +
                            ", Last name = '" + personReader.lastName + '\'' +
                            ", Address = '" + personReader.address + '\'' +
                            ", City = '" + personReader.city + '\'' +
                            ", State = '" + personReader.state + '\'' +
                            ", Zip = '" + personReader.zip + '\'' +
                            ", Contact = '" + personReader.phoneNumber +
                            '}');
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}