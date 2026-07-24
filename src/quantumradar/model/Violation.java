package src.quantumradar.model;

public class Violation {

    private String description;
    private int fine;

    public Violation(String description, int fine) {
        this.description = description;
        this.fine = fine;
    }

    public String getDescription() {
        return description;
    }

    public int getFine() {
        return fine;
    }
}