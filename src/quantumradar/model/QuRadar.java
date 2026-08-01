package src.quantumradar.model;

import src.quantumradar.rules.TrafficRule;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class QuRadar {
    private String plate_number;
    private LocalDate date;
    private CarType type;
    private int speed;
    private boolean is_seatbelt_fastened;
    public QuRadar() //Default constractor
    {
        try (Scanner scanner = new Scanner(System.in)) 
        {
        QuRadar(scanner); //I used the scanner to take input from the user for the attributes of the class as it validates the input and also makes it easier to use the class in the main method.
        }
    }
    public QuRadar(Scanner scanner) {
        //Take data from the user
        System.out.print("Enter plate number: ");
        setPlate_number(scanner.nextLine());
        System.out.print("Enter date (dd-MM-yyyy): ");
        setDate(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.print("Enter car type (Private_CAR/TRUCK/BUS): ");
        String carTypeInput = scanner.nextLine().trim().toUpperCase();
        if (carTypeInput.equals("CAR") || carTypeInput.equals("PRIVATE_CAR")) {
            setType(CarType.PRIVATE_CAR);
        } else {
            setType(CarType.valueOf(carTypeInput));
        }
        System.out.print("Enter speed: ");
        setSpeed(Integer.parseInt(scanner.nextLine().trim()));
        System.out.print("Is seatbelt fastened? (true/false): ");
        setSeatbeltFastened(Boolean.parseBoolean(scanner.nextLine().trim()));
    }

    public QuRadar(String plate_number, LocalDate date, CarType type, int speed, boolean is_seatbelt_fastened) {
        setPlate_number(plate_number);
        setDate(date);
        setType(type);
        setSpeed(speed);
        setSeatbeltFastened(is_seatbelt_fastened);
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isSeatbeltFastened() {
        return is_seatbelt_fastened;
    }

    public void setSeatbeltFastened(boolean is_seatbelt_fastened) {
        this.is_seatbelt_fastened = is_seatbelt_fastened;
    }

    public void displayInfo() {
        System.out.println("Radar Recorded Information:");
        System.out.println("Plate Number: " + getPlate_number());
        System.out.println("Date: " + getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Car Type: " + getType());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Seatbelt Fastened: " + isSeatbeltFastened());
    }

    public void getAllPossibleFines(List<TrafficRule> rules){ //I assumed that this method displays all possible fines for the vechile based on the rules provided
        ArrayList<Violation> violations = new ArrayList<>();

    int total_fine = 0;

    for (TrafficRule rule : rules) {
        Violation violation = rule.check(this);
        if (violation != null) {
            violations.add(violation);
            total_fine += violation.getFine();
        }
    }
        System.out.println();
        if(getType() == CarType.PRIVATE_CAR ){
            System.out.println("Traffic fine for car " + getPlate_number());
        }
        else if(getType() == CarType.TRUCK){
            System.out.println("Traffic fine for truck " + getPlate_number());
        }
        else if(getType() == CarType.BUS){
            System.out.println("Traffic fine for bus " + getPlate_number());
        }
        if(violations.isEmpty()){
            System.out.println("No violations for " + getPlate_number());
            return;
        }
        System.out.println("Total amount: " + total_fine);
        System.out.println("Violations: ");
        for (Violation violation : violations) {
            System.out.println("- " + violation.getDescription() + " : " + violation.getFine() + " EGP");
        }
    }
}
