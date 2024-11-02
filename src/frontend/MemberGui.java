package frontend;

public class MemberGui {
    private String memberID;
    private String name;
    private String memberShipType;
    private String email;
    private String phoneNumber;
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberShipType() {
        return memberShipType;
    }

    public void setMemberShipType(String memberShipType) {
        this.memberShipType = memberShipType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MemberGui(String memberID, String name, String memberShipType, String email, String phoneNumber,String status) {
        this.memberID = memberID;
        this.name = name;
        this.memberShipType = memberShipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }
}
