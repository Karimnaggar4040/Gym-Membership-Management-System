
public class ClassDatabase extends Database<Class>{
    public ClassDatabase(String fileName) {
        super(fileName);
    }
    public Class createRecordFrom(String line) {
        String[] parts = line.split(",");
        Class class_ = new Class(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
        return class_;

    }
    public String getSearchKey(Class record) {
        return record.getSearchKey();
    }

}
