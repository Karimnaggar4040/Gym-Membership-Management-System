package backend;
import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends Database{
    public MemberClassRegistrationDatabase(String fileName) {
        super(fileName);
    }

    public MemberClassRegistration createRecordFrom(String line) {

        String[] parts = line.split(",");
        return new MemberClassRegistration(parts[0], parts[1], LocalDate.parse(parts[2]),parts[3] );
    }
}
