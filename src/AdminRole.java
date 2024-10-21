public class AdminRole {
    private TrainerDatabase database;

    // DEFAULT CONSTRUCTOR
    public AdminRole() {
        // Prepare the system to manage trainers by accessing the TrainerDatabase
    }

    // METHODS
    public void addTrainer (String trainerId, String name, String email, String specialty, String
            phoneNumber){}

    public Trainer[] getListOfTrainers(){}

    public void removeTrainer(String key){}

    public void logout(){}
}
