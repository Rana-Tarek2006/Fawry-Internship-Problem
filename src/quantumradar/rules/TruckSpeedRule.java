package src.quantumradar.rules;

import src.quantumradar.model.CarType;
import src.quantumradar.model.QuRadar;
import src.quantumradar.model.Violation;

public class TruckSpeedRule implements TrafficRule {
    private static final int TRUCK_SPEED_LIMIT = 60;
    private static final int SPEED_FINE = 300;

    @Override
    public Violation check(QuRadar radar) {
        if (radar.getType() == CarType.TRUCK && radar.getSpeed() > TRUCK_SPEED_LIMIT) {
            return new Violation("Speed of " + radar.getSpeed() + " exceeded max allowed " + TRUCK_SPEED_LIMIT, SPEED_FINE);
        }
        return null;
    }
}

