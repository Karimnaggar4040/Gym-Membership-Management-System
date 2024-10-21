public class MemberClassRegistration {
    private String memberID;
    private String classID;
    private String status;

    private String registrationDate; //! local 

    
    // CONSTRUCTORS
    public MemberClassRegistration(String memberID, String classID, String status, String registrationDate) {
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getSearchKey() {
        return memberID + classID;
    }

    public String lineRepresentation() {
        return memberID + "," + classID + "," + registrationDate + "," + status;
    }
    
}
