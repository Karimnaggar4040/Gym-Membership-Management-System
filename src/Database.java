import java.io.FileWriter;
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
//            if (content.isEmpty()){
//                System.out.println("Empty file");
//            }
            content = content.replace(" ","");
            String[] lines = content.split("\n");
            for (String line : lines) {
                line = line.replace("\r","");
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
        for (PrimaryInterface record1 : records) {
            if (record1.getSearchKey().equals(record.getSearchKey())) {
                System.out.println("This data already exists"); // We can edit the print statement later,is the record we are trying to enter already exists if will show this line then return.
                System.out.println("Please try again");
                return;
            }
        }
        records.add(record);
        System.out.println("Added Successfully");
    }

    public void deleteRecord(String key) {
        for (PrimaryInterface record : records) {
            if (record.getSearchKey().equals(key)) {
                records.remove(record);
                return;
            }
        }
        System.out.println("There is no user with this data");
    }

    public void saveToFile() {
       try{
           FileWriter file = new FileWriter(fileName,false); //false means append is false, will overwrite
           for (PrimaryInterface record : records) {
               file.write(record.lineRepresentation());
               file.write("\n");
           }
           System.out.println("File saved successfully");
           file.close();
       }catch (IOException e){
           throw new RuntimeException(e);
       }
    }
}
