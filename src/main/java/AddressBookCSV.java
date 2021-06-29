import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

public class AddressBookCSV {
    private static String HOME = System.getProperty("user.dir");
    private static String fName = "AddressBookCSV.csv";
    private static Path homePath = Paths.get(HOME);

    public static boolean readCSV() throws IOException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fName);
            try {
                if (Files.exists(filePath)) {
                    FileReader filereader = new FileReader(String.valueOf(filePath));
                    CSVReader csvReader = new CSVReader(filereader);
                    String[] nextRecord;
                    while ((nextRecord = csvReader.readNext()) != null) {
                        for (String cell : nextRecord) {
                            System.out.print(cell + "\t");
                        }
                        System.out.println(" ");
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean writeCSV(List<String[]> personList) throws IOException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fName);
            try {
                CSVWriter writer;
                if (Files.exists(filePath)) {
                    FileWriter outputfile = new FileWriter(String.valueOf(filePath));
                    CSVWriter writeNext = new CSVWriter(outputfile);
                    for (String[] person : personList) {
                        writeNext.writeNext(person);
                    }
                    writeNext.flush();
                    writeNext.close();
                    return true;
                } else {
                    Files.createFile(filePath);
                    FileWriter outputfile = new FileWriter(String.valueOf(filePath));
                    CSVWriter writeNext = new CSVWriter(outputfile);
                    for (String[] person : personList) {
                        writeNext.writeNext(person);
                    }
                    writeNext.close();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        } else
            return false;

    }
}