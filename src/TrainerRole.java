import javax.imageio.spi.RegisterableService;
import java.time.LocalDate;

public class TrainerRole {

    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    // DEFAULT CONSTRUCTOR
    public TrainerRole() {
        // Prepare the system to manage trainers by accessing the TrainerDatabase
        classDatabase = new ClassDatabase("Classes.txt");
        memberDatabase = new MemberDatabase("Members.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("Registrations.txt");
    }

    // METHODS
    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(member); // check if it's already exist in the database file
    }
    
    public Member[] getListOfMembers() {
        return memberDatabase.returnAllRecords().toArray(new Member[0]);  // new syntax need testing

    }
    
    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class class1 = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(class1); // check if it's already exist in the database file
    }
    
    public Class[] getListOfClasses() {
        return classDatabase.returnAllRecords().toArray(new Class[0]);  // new syntax need testing
    }
    
    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        Class[] classes = getListOfClasses();
        Member[] members = getListOfMembers();
        
        MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, registrationDate);
        registrationDatabase.insertRecord(registration); // check if it's already exist in the database file
    }
    
    public boolean cancelRegistration(String memberID, String classID) {

    }
    
    public MemberClassRegistration[] getListOfRegistrations() {
        
    }

    public void logout() {

    }
}
