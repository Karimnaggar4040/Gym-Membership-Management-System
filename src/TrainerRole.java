import javax.imageio.spi.RegisterableService;

public class TrainerRole {

    private MemberDatabase memberDatabase;
    private TrainerDatabase trainerDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    // DEFAULT CONSTRUCTOR
    public TrainerRole() {
        // Prepare the system to manage trainers by accessing the TrainerDatabase
        trainerDatabase = new TrainerDatabase("Trainers.txt");
        memberDatabase = new MemberDatabase("Members.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("Registrations.txt");
    }

    // METHODS
    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber,
            String status) {

    }
    
    public Member[] getListOfMembers() {

    }
    
    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {

    }
    
    public Class[] getListOfClasses() {

    }
    
    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {

    }
    
    public boolean cancelRegistration(String memberID, String classID) {

    }
    
    public MemberClassRegistration[] getListOfRegistrations() {
        
    }

    public void logout() {

    }
}
