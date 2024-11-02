package frontend;

import java.time.LocalDate;

public class MemberRegistrationGui {
    private String memberId;
    private String classId;
    private String status;
    private LocalDate registrationDate;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public MemberRegistrationGui(String memberId, String classId, LocalDate registrationDate,String status) {
        this.memberId = memberId;
        this.classId = classId;
        this.status = status;
        this.registrationDate = registrationDate;
    }
}
