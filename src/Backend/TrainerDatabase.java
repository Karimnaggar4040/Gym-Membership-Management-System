package Backend;
// Class Responsible for accessing the file Trainers.txt ( R/W )

public class TrainerDatabase extends Database {
    // CONSTRUCTOR
    public TrainerDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Trainer(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
