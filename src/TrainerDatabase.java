// Class Responsible for accessing the file Trainers.txt ( R/W )

import java.util.ArrayList;

public class TrainerDatabase {
    private ArrayList<Trainer> records;
    private String fileName;

    // CONSTRUCTOR
    public TrainerDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<Trainer>();
    }

    // METHODS
    public void readFromFile() {

    }

    public Trainer createRecordFrom(String line) {
        String[] parts = line.split(",");
        Trainer trainer = new Trainer(parts[0], parts[1], parts[2], parts[3], parts[4]);
        return trainer;
    }

    public ArrayList<Trainer> returnAllRecords() {
        return records;
    }

    public boolean contains (String key){
        for (Trainer record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Return null if not found
    public Trainer getRecord (String key){
        for (Trainer record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (Trainer record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }

}
