import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        try {
            String content = Files.readString(Paths.get(fileName));
            String[] lines = content.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");

                Member member= new Member (parts[0], parts[1], parts[2], parts[3],parts[4],parts[5]);
                records.add(member);
            }
            for (Member member : records) {
                System.out.println("records: " + member.lineRepresentation());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Member createRecordFrom(String line) {
        String[] parts = line.split(",");
        Member member = new Member(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
        return member;
    }

    public ArrayList<Member> returnAllRecords() {
        return records;
    }

    public boolean contains (String key){
        for (Member record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Return null if not found
    public Member getRecord (String key){
        for (Member record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord (Member record){

    }

    public void deleteRecord (String key){

    }

    public void saveToFile() {

    }

}
