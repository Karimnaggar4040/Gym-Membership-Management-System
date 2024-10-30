package Backend;
public class Trainer implements PrimaryInterface {
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

    @Override
    public String lineRepresentation() {
        return trainerId + "," + name + "," + email + "," + speciality + "," + phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return trainerId;
    }
}
