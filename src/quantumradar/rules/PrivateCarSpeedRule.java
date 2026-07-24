package src.quantumradar.rules;

import src.quantumradar.model.CarType;
import src.quantumradar.model.QuRadar;
import src.quantumradar.model.Violation;

public class PrivateCarSpeedRule implements TrafficRule {
    private static final int PRIVATE_CAR_SPEED_LIMIT = 80;
    private static final int SPEED_FINE = 300;

    @Override
    public Violation check(QuRadar radar) {
        if (radar.getType() == CarType.PRIVATE_CAR && radar.getSpeed() > PRIVATE_CAR_SPEED_LIMIT) {
            return new Violation("Speed of " + radar.getSpeed() + " exceeded max allowed " + PRIVATE_CAR_SPEED_LIMIT, SPEED_FINE);
        }
        return null;
    }
}