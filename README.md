# Gym Management System (Backend)

A robust, Java-based backend architecture designed to manage operations for a gym or fitness center. The system handles trainers, gym members, fitness classes, and class registrations. 

Built with a strong focus on **Object-Oriented Programming (OOP) principles**, this project utilizes abstract data persistence, role-based business logic, and modular design to create a highly scalable and maintainable backend.

## Core Features

### Role-Based Access Control
The system separates business logic into distinct roles, ensuring data security and operational clarity:
* **Admin Role (`AdminRole`):** Has top-level access to manage the gym's staff. Admins can add, remove, and view Trainers.
* **Trainer Role (`TrainerRole`):** Manages the day-to-day gym operations. Trainers can add new Members, schedule new Classes, register Members to specific Classes, and handle registration cancellations.

### Automated Business Logic
* **Dynamic Seat Management:** The system automatically checks class capacity before allowing a registration and dynamically decrements/increments available seats upon registration or cancellation.
* **Refund Policy Handling:** Enforces a strict 3-day refund policy. If a member cancels their registration within 3 days of booking, the system processes a refund; otherwise, the cancellation is denied.

### File-Based Persistence
Data is persistently stored across sessions using a custom CSV-style file management system. Changes made during a session are held in memory and securely written to local `.txt` files (`Trainers.txt`, `Members.txt`, etc.) upon system logout.

---

## Object-Oriented Architecture

This project strictly adheres to advanced OOP principles to eliminate code duplication and ensure system flexibility.

### 1. Abstraction & Interface Contracts
* **`PrimaryInterface`:** The backbone of the entity system. Every core entity (`Trainer`, `Member`, `Class`, `MemberClassRegistration`) implements this interface. It strictly enforces the `getSearchKey()` and `lineRepresentation()` methods, ensuring that any entity can be searched and serialized into text without the database knowing the specific object type.
* **`Database` (Abstract Class):** Abstracted the entire file I/O (Input/Output) and CRUD (Create, Read, Update, Delete) logic. It handles reading files, parsing lines, checking for duplicates, and saving back to disk.

### 2. Inheritance
* Instead of rewriting database logic for every entity, concrete database classes (`TrainerDatabase`, `MemberDatabase`, `ClassDatabase`, `MemberClassRegistrationDatabase`) inherit from the abstract `Database` class. 
* These subclasses only need to implement a single abstract method: `createRecordFrom(String line)`, injecting their specific object instantiation logic into the universal database engine.

### 3. Polymorphism
* **Generic Collections:** The `Database` class manages an `ArrayList<PrimaryInterface>`. This polymorphic collection allows the system to store, search, and delete *any* entity type using the exact same methods.
* **Dynamic Type Casting:** When specific entity methods are needed (e.g., checking `getAvailableSeats()` on a `Class`), the `TrainerRole` safely casts the `PrimaryInterface` back to its concrete type, leveraging Java's `instanceof` validations.

### 4. Encapsulation & The Facade Pattern
* **`Backend` (Facade):** Acts as a unified facade for the entire system. Instead of the UI/Main application interacting with databases directly, it routes all requests through the `Backend` class, which delegates tasks to either `AdminRole` or `TrainerRole`.
* **State Protection:** All entity attributes (IDs, seats, dates, contact info) are strictly private. Modifications (like updating registration statuses to "cancelled") are handled securely via specific setters.

---

## Project Structure

```text
backend/
├── Interfaces & Abstract Classes
│   ├── PrimaryInterface.java      # Base contract for all storable entities
│   └── Database.java              # Abstract generic CRUD and File I/O handler
│
├── Entities (Models)
│   ├── Trainer.java
│   ├── Member.java
│   ├── Class.java
│   └── MemberClassRegistration.java
│
├── Persistence (Databases)
│   ├── TrainerDatabase.java
│   ├── MemberDatabase.java
│   ├── ClassDatabase.java
│   └── MemberClassRegistrationDatabase.java
│
└── Business Logic & Controllers
    ├── AdminRole.java             # Trainer management logic
    ├── TrainerRole.java           # Member, Class, and Registration logic
    └── Backend.java               # Main facade and routing controller
```

---

## Getting Started

### Prerequisites
* **Java Development Kit (JDK):** Version 11 or higher.
* Ensure you have a `constants` package or interface (e.g., `FileNames.java`) configured in your project to provide the file paths (e.g., `FileNames.TRAINER_FILENAME`).

### Installation & Execution
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure the local text files (e.g., `Trainers.txt`, `Members.txt`) are either present in the root directory or allow the `Database` class to generate them automatically upon first run.
4. Interact with the system via the static methods provided in the `Backend.java` class.

### Data Saving Note
Remember to always call `Backend.adminLogout()` or `Backend.trainerLogout()` before shutting down the application. This triggers the `saveToFile()` methods, ensuring all in-memory `ArrayList` changes are permanently written to your local storage.
