import java.util.ArrayList;

public class AdminRole {
    private TrainerDatabase database;

    // DEFAULT CONSTRUCTOR
    public AdminRole() {
        // Prepare the system to manage trainers by accessing the TrainerDatabase
        database = new TrainerDatabase("Trainers.txt");
        database.readFromFile();
    }

    // METHODS
    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(trainer);// check if it's already exist in the database file
    }

    public ArrayList<PrimaryInterface> getListOfTrainers() {
        return database.returnAllRecords(); // new syntax need testing
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key);// if key not found need to be handled => Handled in the deleteRecord method
    }

    public void logout() {
        // ensure all data is saved
        database.saveToFile();
    }
}
