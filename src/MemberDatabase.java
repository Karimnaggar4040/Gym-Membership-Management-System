import java.util.ArrayList;

import java.util.ArrayList;

public class MemberDatabase {
    private ArrayList<Member> records;
    private String fileName;

    public MemberDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<Member>();
    }


    // METHODS
    public void readFromFile() {

    }

    public Member createRecordFrom(String line){

    }

    public ArrayList<Member> returnAllRecords() {

    }

    public boolean contains (String key){

    }

    // Return null if not found
    public Member getRecord (String key){

    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (Member record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }
    
}
