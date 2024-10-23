import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Database{
    private ArrayList<PrimaryInterface> records;
    private String fileName;

    public Database(String fileName) {
        this.fileName = fileName;
        this.records = new ArrayList<>();
    }

    // METHODS
    public void readFromFile() {
        try {
            String content = Files.readString(Paths.get(fileName));
            String[] lines = content.split("\n");
            for (String line : lines) {
                PrimaryInterface newRecord = createRecordFrom(line);
                records.add(newRecord);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Abstract methods to be implemented in subclasses
    public abstract PrimaryInterface createRecordFrom(String line);

    public ArrayList<PrimaryInterface> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (PrimaryInterface record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public PrimaryInterface getRecord(String key) {
        for (PrimaryInterface record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(PrimaryInterface record) {
        
    }

    public void deleteRecord(String key) {
        
    }

    public void saveToFile() {
       
    }
}
