import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;

public class ClassDatabase {
    private ArrayList<Class> records;
    private String fileName;

    public ClassDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<Class>();
    }


    // METHODS
    public void readFromFile() {
        try {
            String content = Files.readString(Paths.get(fileName));
            String[] lines = content.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");

                Class newClass = new Class (parts[0], parts[1], parts[2], Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
                records.add(newClass);
            }
            for (Class newClass : records) {
                System.out.println("records: " + newClass.lineRepresentation());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Class createRecordFrom(String line) {
        String[] parts = line.split(",");
        Class class_ = new Class(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
        return class_;

    }

    public ArrayList<Class> returnAllRecords() {
        return records;
    }

    public boolean contains (String key){
        for (Class record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Return null if not found
    public Class getRecord (String key){
        for (Class record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (Class record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }

}
