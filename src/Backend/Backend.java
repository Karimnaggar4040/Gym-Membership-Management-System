package Backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend {
    // TODO : Check if the type of these 2 global variables are right
    static AdminRole adminRole = new AdminRole();
    static TrainerRole trainerRole = new TrainerRole();

    public static void main(String[] args) {

    }


    // DONE
    public static boolean addTrainer(String id, String name, String email, String speciality, String phoneNumber) {
        return adminRole.addTrainer(id, name, email, speciality, phoneNumber);
    }

    public static boolean addMember(String id, String name, String membershipType, String email, String phoneNumber,String status) {
        return trainerRole.addMember(id, name, membershipType, email, phoneNumber, status);
    }

    public static boolean addNewClasses(String classID,String className,String trainerID,int duration,int seats) {
        return trainerRole.addClass(classID, className, trainerID, duration, seats);
    }

    public static boolean addMemberRegistration(String memberID,String classID, LocalDate registrationDate) {
        return trainerRole.registerMemberForClass(memberID, classID, registrationDate);
    } // DONE

    // TODO: method needs to handle if the user has multiple classes registered to
    private static void seeRegisteredClasses() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the Class's ID: ");
        String classID = scanner.nextLine();
        PrimaryInterface memberClassRegistration = Backend.searchForMemberRegistrations(id + classID);

        if (memberClassRegistration == null) {
            System.out.println("Member registration not found");
            return;
        }
        System.out.println("Member Registration Found");
        System.out.println("Member Registration Details:");
        System.out.println(memberClassRegistration.lineRepresentation());
    }

    private static void cancelClassRegistration() {
        System.out.println("size before: " + trainerRole.getListOfRegistrations().size());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Member's ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Class's ID: ");
        String classID = sc.nextLine();
        trainerRole.cancelRegistration(id, classID);
        System.out.println("size after: " + trainerRole.getListOfRegistrations().size());
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
        PrimaryInterface trainer = Backend.searchForTrainer(trainerID);

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
}

