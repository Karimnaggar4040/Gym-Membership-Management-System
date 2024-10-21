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

    }

    public Class createRecordFrom(String line){

    }

    public ArrayList<Class> returnAllRecords() {

    }

    public boolean contains (String key){

    }

    // Return null if not found
    public Class getRecord (String key){

    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (Class record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }
    
}
