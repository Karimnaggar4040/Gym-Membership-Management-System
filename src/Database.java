import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Database<T> {
    protected ArrayList<T> records;
    protected String fileName;

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
                T newRecord = createRecordFrom(line);
                records.add(newRecord);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Abstract methods to be implemented in subclasses
    public abstract T createRecordFrom(String line);

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (T record : records) {
            if (getSearchKey(record).equals(key)) {
                return true;
            }
        }
        return false;
    }

    public T getRecord(String key) {
        for (T record : records) {
            if (getSearchKey(record).equals(key)) {
                return record;
            }
        }
        return null;
    }

    public abstract String getSearchKey(T record);

    public void insertRecord(T record) {
        
    }

    public void deleteRecord(String key) {
        
    }

    public void saveToFile() {
       
    }
}
