import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.time.LocalDate;

public class MemberClassRegistrationDatabase {
    private ArrayList<MemberClassRegistration> records;
    private String fileName;

    public MemberClassRegistrationDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<MemberClassRegistration>();
    }


    // METHODS
    public void readFromFile() {
        try {
            String content = Files.readString(Paths.get(fileName));
            String[] lines = content.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");

                LocalDate date = LocalDate.parse(parts[2]);
                MemberClassRegistration memberClassRegistration = new MemberClassRegistration(parts[0], parts[1], date, parts[3]);
                records.add(memberClassRegistration);
            }
            for (MemberClassRegistration memberClassRegistration : records) {
                System.out.println("records: " + memberClassRegistration.lineRepresentation());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MemberClassRegistration createRecordFrom(String line) {
        String[] parts = line.split(",");
        MemberClassRegistration memberClassRegistration = new MemberClassRegistration(parts[0], parts[1], LocalDate.parse(parts[2]),parts[3] );
        return memberClassRegistration;

    }

    public ArrayList<MemberClassRegistration> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (MemberClassRegistration record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Return null if not found
    public MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    // Checks first if the trainer already exists (method contains)
    public void insertRecord(MemberClassRegistration record) {

    }

    public void deleteRecord(String key) {

    }

    public void saveToFile() {

    }

}
