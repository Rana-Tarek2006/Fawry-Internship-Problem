package src.quantumradar;

import src.quantumradar.model.*;
import src.quantumradar.rules.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void getAllViolatedRulesWithCount(ArrayList<QuRadar> radars) {

    int seatbeltViolations = 0;
    int privateCarSpeedViolations = 0;
    int truckSpeedViolations = 0;

    for (QuRadar radar : radars) {

        // Seatbelt rule
        if (!radar.isSeatbeltFastened()) {
            seatbeltViolations++;
        }

        // Private car speed rule
        if (radar.getType() == CarType.PRIVATE_CAR &&
                radar.getSpeed() > 80) {

            privateCarSpeedViolations++;
        }

        // Truck speed rule
        if (radar.getType() == CarType.TRUCK &&
                radar.getSpeed() > 60) {

            truckSpeedViolations++;
        }
    }

    System.out.println("Violated Rules Summary for all vehicles:");
    System.out.println("Seatbelt not fastened : " + seatbeltViolations);
    System.out.println("Private car speed limit : " + privateCarSpeedViolations);
    System.out.println("Truck speed limit : "+ truckSpeedViolations);
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) 
        {
            ArrayList<QuRadar> radars = new ArrayList<>();
            radars.add(new QuRadar("ABC123", LocalDate.of(2026, 5, 18), CarType.PRIVATE_CAR, 90, false));
            radars.add(new QuRadar(scanner)); //To test the constructor that takes input from the user
            radars.add(new QuRadar("XYZ789", LocalDate.of(2026, 6, 21), CarType.TRUCK, 70, true));
            radars.add(new QuRadar(scanner)); //To test it after taking a previos input ,and the no violations display.
            ArrayList<TrafficRule> rules = new ArrayList<>();
            rules.add(new SeatbeltRule());
            rules.add(new PrivateCarSpeedRule());
            rules.add(new TruckSpeedRule());
            for (QuRadar radar : radars) {
                radar.getAllPossibleFines(rules);
            }
            getAllViolatedRulesWithCount(radars);
        }
    }
}