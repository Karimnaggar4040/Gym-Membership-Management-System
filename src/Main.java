import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // TODO : Check if the type of these 2 global variables are right
    static AdminRole adminRole = new AdminRole();
    static TrainerRole trainerRole = new TrainerRole();

    public static void main(String[] args) {
cancelClassRegistration();
trainerRole.logout();
    }

    // MENUS METHODS
    /*
    public static void menuGeneral() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("################################");
                System.out.println("Choose your Role");
                System.out.println("1. Admin");
                System.out.println("2. Trainer");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        menuAdmin();
                        break;
                    }
                    case 2: {
                        menuTrainer();
                        break;
                    }
                    case 3: {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Invalid Choice, please try again");
                        menuGeneral();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
            menuGeneral();
        }
    }

    //   private static void menuTrainer() {
//        Scanner sc = new Scanner(System.in);
//        try{
//            while (true) {
//                System.out.println("################################");
//                System.out.println("Enter Your Choice");
//
//            }
//        }catch (Exception e){
//            System.out.println("Something went wrong, please try again");
//            menuTrainer();
//        }
//    }

    private static void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("#################################");
                System.out.println("Choose what you want to do");
                System.out.println("1. Add Trainer");
                System.out.println("2. Add Remove Trainer");
                System.out.println("3. Display Trainer");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        Main.addTrainer();
                        break;
                    }
                    case 2: {
                        Main.deleteTrainer();
                        break;
                    }
                    case 3: {
                        Main.displayTrainer();
                        break;
                    }
                    case 4: {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Invalid Choice, Please try again");
                        menuGeneral();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
            menuGeneral();
        }
    }

     */

    // DONE
    private static void addTrainer() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Speciality: ");
            String speciality = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            adminRole.addTrainer(id, name, email, speciality, phoneNumber);
            System.out.println("Size of the list of trainers: " + adminRole.getListOfTrainers().size());
        } catch (RuntimeException e) {
            System.out.println("Error happened while inputting data please try again ");
            Main.addTrainer();
            throw new RuntimeException(e);
        }
    } // DONE

    private static void addMember() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Membership Type: ");
            String membershipType = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter Status: ");
            String status = scanner.nextLine();
            trainerRole.addMember(id, name, membershipType, email, phoneNumber, status);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    } // DONE

    private static void addNewClasses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size before: " + trainerRole.getListOfClasses().size());
        try {
            System.out.print("Enter Class's ID: ");
            String classID = scanner.nextLine();
            System.out.print("Enter Class's Name: ");
            String className = scanner.nextLine();
            System.out.print("Enter Class's Trainer ID: ");
            String trainerID = scanner.nextLine();
            System.out.print("Enter Class's Duration: ");
            int duration = scanner.nextInt();
            System.out.print("Set Class's Seats: ");
            int seats = scanner.nextInt();
            trainerRole.addClass(classID, className, trainerID, duration, seats);
            System.out.println("Size after: " + trainerRole.getListOfClasses().size());
        } catch (Exception e) {
            System.out.println("You have entered invalid data, please try again");
            addNewClasses();
        }

    } // DONE

    private static void addMemberRegistration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Member's ID: ");
        String memberID = scanner.nextLine();
        System.out.println("Enter Class's ID: ");
        String classID = scanner.nextLine();
        LocalDate registration = LocalDate.now();
        boolean confirmation = trainerRole.registerMemberForClass(memberID, classID, registration);
        if (!confirmation) {
            System.out.println("Member can't be registered");
        }
    } // DONE

    // TODO: method needs to handle if the user has multiple classes registered to
    private static void seeRegisteredClasses() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the Class's ID: ");
        String classID = scanner.nextLine();
        PrimaryInterface memberClassRegistration = Main.searchForMemberRegistrations(id + classID);

        if (memberClassRegistration == null) {
            System.out.println("Member registration not found");
            return;
        }
        System.out.println("Member Registration Found");
        System.out.println("Member Registration Details:");
        System.out.println(memberClassRegistration.lineRepresentation());
    }

    private static void cancelClassRegistration() {
        System.out.println("size before: "+trainerRole.getListOfRegistrations().size());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Member's ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Class's ID: ");
        String classID = sc.nextLine();
        trainerRole.cancelRegistration(id,classID);
        System.out.println("size after: "+trainerRole.getListOfRegistrations().size());
    } // DONE

    private static void seeAvailableClasses() {
        ArrayList<Class> classes = trainerRole.getListOfClasses();
        System.out.println("Classes available: ");
        for (Class class1 : classes) {
            if (class1.getAvailableSeats() > 0) {
                System.out.println(class1.lineRepresentation());
            }
        }
    } // DONE

    private static void deleteTrainer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the trainer's ID: ");
        String trainerID = scanner.nextLine();
        adminRole.removeTrainer(trainerID);
    } // DONE

    private static void displayTrainer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the trainer's ID: ");
        String trainerID = scanner.nextLine();
        PrimaryInterface trainer = Main.searchForTrainer(trainerID);

        if (trainer == null) {
            System.out.println("Trainer not found");
            return;
        }
        System.out.println("Trainer Details");
        System.out.println(trainer.lineRepresentation());
    } // DONE


    // The 4 search functions for all persons (DONE)
    private static PrimaryInterface searchForTrainer(String key) {
        System.out.println("Searching for trainer with ID: " + key);
        for (PrimaryInterface trainer : adminRole.getListOfTrainers()) {
            if (trainer.getSearchKey().equals(key))
                return trainer;
        }
        return null;
    }

    private static PrimaryInterface searchForMember(String key) {
        for (PrimaryInterface member : trainerRole.getListOfMembers()) {
            if (member.getSearchKey().equals(key))
                return member;
        }
        return null;
    }

    private static PrimaryInterface searchForClass(String key) {
        for (PrimaryInterface classes : trainerRole.getListOfClasses()) {
            if (classes.getSearchKey().equals(key))
                return classes;
        }
        return null;
    }

    private static PrimaryInterface searchForMemberRegistrations(String key) {
        for (PrimaryInterface memberRegistrations : trainerRole.getListOfRegistrations()) {
            if (memberRegistrations.getSearchKey().equals(key))
                return memberRegistrations;
        }
        return null;
    }


//    private static void addMemberClassRegistration (){
//        Scanner scanner = new Scanner(System.in);
//        try{
//            System.out.print("Enter Member ID: ");
//            String memberID = scanner.nextLine();
//            System.out.print("Enter Class ID: ");
//            String classID = scanner.nextLine();
//            System.out.println("Enter Status");
//            String status = scanner.nextLine();
//
//        }
//    }
}
// System.out.println(" ################################################## ");
// Trainer trainer1 = new Trainer("T001", "John Doe", "john@gmail.com", "Yoga", "12345678");
// System.out.println(trainer1.lineRepresentation());
// System.out.println(trainer1.getSearchKey());

// System.out.println();
// System.out.println(" ################################################## ");
// Member member1 = new Member("M001", "Jane Doe", "monthly", "Jane@gmail.com", "87654321", "active");
// System.out.println(member1.lineRepresentation());
// System.out.println(member1.getSearchKey());

// System.out.println();
// System.out.println(" ################################################## ");
// Class class1 = new Class("C001", "Yoga", "T001", 60, 20);
// System.out.println(class1.lineRepresentation());
// System.out.println(class1.getSearchKey());
// System.out.println(class1.getAvailableSeats());
// class1.setAvailableSeats(10);
// System.out.println(class1.getAvailableSeats());


// System.out.println();
// System.out.println(" ################################################## ");
// MemberClassRegistration memberClassRegistration1 = new MemberClassRegistration("M001", "C001", "active", LocalDate.of(2021, 10, 10));
// System.out.println(memberClassRegistration1.lineRepresentation());
// System.out.println(memberClassRegistration1.getSearchKey());
// System.out.println(memberClassRegistration1.getClassID());
// System.out.println(memberClassRegistration1.getMemberID());
// System.out.println(memberClassRegistration1.getRegistrationDate());

//        TrainerDatabase trainerDatabase = new TrainerDatabase("Trainers.txt");
//        trainerDatabase.readFromFile();
// Main.displayTrainer();
