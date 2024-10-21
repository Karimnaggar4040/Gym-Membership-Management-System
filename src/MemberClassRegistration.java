import java.time.LocalDate;

public class MemberClassRegistration {
    private String memberID;
    private String classID;
    private String status;

    private LocalDate registrationDate; // format : YYYY-MM-DD

    
    // CONSTRUCTORS
    public MemberClassRegistration(String memberID, String classID, LocalDate registrationDate, String status) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    // METHODS
    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getSearchKey() {
        return memberID + classID;
    }

    public String lineRepresentation() {
        return memberID + "," + classID + "," + registrationDate + "," + status;
    }
    
}
