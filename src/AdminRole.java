public class AdminRole {
    private TrainerDatabase database;

    // DEFAULT CONSTRUCTOR
    public AdminRole() {
        // Prepare the system to manage trainers by accessing the TrainerDatabase
        database = new TrainerDatabase("Trainers.txt");
    }

    // METHODS
    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(trainer); // check if it's already exist in the database file
    }

    public Trainer[] getListOfTrainers() {
        return database.returnAllRecords().toArray(new Trainer[0]);  // new syntax need testing
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key); // if key not found need to be handled
    }

    public void logout() {
        // ensure all data is saved
        database.saveToFile();
    }
}
