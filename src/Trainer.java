public class Trainer {
    private String trainerId;
    private String name;
    private String email;
    private String speciality;
    private String phoneNumber;

    // CONSTRUCTOR
    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    // METHODS
    public String lineRepresentation(Trainer trainer) {

    }

    public String getSearchKey(Trainer trainer) {
        return trainer.trainerId;
    }

}
