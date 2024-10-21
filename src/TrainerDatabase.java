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

    public Trainer createRecordFrom(String line){

    }

    public ArrayList<Trainer> returnAllRecords() {

    }

    public boolean contains (String key){

    }

    // Return null if not found
    public Trainer getRecord (String key){

    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (Trainer record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }

    // TODO: Update method (Private)
}
