package backend;
public class MemberDatabase extends Database{

    public MemberDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Member(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }
}
