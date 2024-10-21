import java.util.ArrayList;

import java.util.ArrayList;

public class MemberClassRegistrationDatabase{
    private ArrayList<MemberClassRegistration> records;
    private String fileName;

    public MemberClassRegistrationDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<MemberClassRegistration>();
    }


    // METHODS
    public void readFromFile() {

    }

    public MemberClassRegistration createRecordFrom(String line){

    }

    public ArrayList<MemberClassRegistration> returnAllRecords() {

    }

    public boolean contains (String key){

    }

    // Return null if not found
    public MemberClassRegistration getRecord (String key){

    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (MemberClassRegistration record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }
    
}
