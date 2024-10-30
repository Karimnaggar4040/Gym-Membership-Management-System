public class Class implements PrimaryInterface {
    private String classID;
    private String className;
    private String trainerID;
    private int duration;
    private int availableSeats;

    //only one appointment

    // CONSTRUCTORS
    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    // METHODS
    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String lineRepresentation() {
        return classID + "," + className + "," + trainerID + "," + duration + "," + availableSeats;
    }

    @Override
    public String getSearchKey() {
        return classID;
    }
    
    
}

