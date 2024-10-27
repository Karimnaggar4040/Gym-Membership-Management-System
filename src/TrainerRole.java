import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole {
    private Database memberDatabase;
    private Database classDatabase;
    private Database registrationDatabase;

    // DEFAULT CONSTRUCTOR
    public TrainerRole() {
        // Prepare the system to manage trainers by accessing the TrainerDatabase
        classDatabase = new ClassDatabase("Classes.txt");
        classDatabase.readFromFile();
        memberDatabase = new MemberDatabase("Members.txt");
        memberDatabase.readFromFile();
        registrationDatabase = new MemberClassRegistrationDatabase("Registrations.txt");
        registrationDatabase.readFromFile();
    }

    // METHODS
    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(member); // check if it's already exist in the database file
    }

    public ArrayList<PrimaryInterface> getListOfMembers() {
        return memberDatabase.returnAllRecords();  // new syntax need testing

    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class class1 = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(class1); // check if it's already exist in the database file
    }

    public ArrayList<Class> getListOfClasses() {
        ArrayList<PrimaryInterface> registrations = classDatabase.returnAllRecords();
        ArrayList<Class> classes = new ArrayList<>();
        for (PrimaryInterface registration : registrations) {
            if (registration instanceof Class)
                classes.add((Class) registration);
        }
        return classes;
    }

    // We will need to access the method getAvailableSeats in the main, so we can't return an ArrayList of type PrimaryInterface because then the method getAvailable won't be seen in the main
    public ArrayList<PrimaryInterface> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        PrimaryInterface classInterface = classDatabase.getRecord(classID);  // should i cast this? or should i do the loop or somthing else??
        if (classInterface instanceof Class) {
            Class c = (Class) classInterface; // need to rethink about using casting here
            // verify the date
            if (c.getAvailableSeats() > 0) {
                MemberClassRegistration registration = new MemberClassRegistration(memberID, classID,
                        registrationDate, "active");
                registrationDatabase.insertRecord(registration); // check if it's already exist in the database file => DONE
                c.setAvailableSeats(c.getAvailableSeats() - 1); // decrement the available seats
                return true;
            }
        }

        // loop approach

        // Class[] classes = getListOfClasses();
        // for (Class c : classes) {
        //     if (c.getSearchKey().equals(classID)) {
        //         if (c.getAvailableSeats() > 0) {
        //             MemberClassRegistration registration = new MemberClassRegistration(memberID, classID,
        //                     registrationDate, "active");
        //             registrationDatabase.insertRecord(registration); // check if it's already exist in the database file
        //             c.setAvailableSeats(c.getAvailableSeats() - 1); // decrement the available seats
        //             return true;
        //         }
        //     }
        // }

        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        PrimaryInterface recordInterface = registrationDatabase.getRecord(memberID + classID);
        if (recordInterface instanceof MemberClassRegistration) {
            MemberClassRegistration record = (MemberClassRegistration) recordInterface; // need to rethink about using casting here
            // verify the date
            LocalDate record_date = record.getRegistrationDate();
            LocalDate today = LocalDate.now();

            // refund if the member cancels within 3 days of registration
            if (!record_date.plusDays(3).isBefore(today)) {
                System.out.println("You have a refund"); // el mafroud a3mel 7aga tania wala eh?
            }
            // update status to "cancelled" if the cancellation is valid
            record.setRegistrationStatus("cancelled");

            // increment the available seats in classDatabase
            Class c = (Class) classDatabase.getRecord(classID);
            c.setAvailableSeats(c.getAvailableSeats() + 1);
            return true;
        }
        return false;
    }

    public void logout() {
        // save all the data to the database files
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }
}
