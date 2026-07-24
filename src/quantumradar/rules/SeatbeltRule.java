package src.quantumradar.rules;

import src.quantumradar.model.QuRadar;
import src.quantumradar.model.Violation;

public class SeatbeltRule implements TrafficRule {
    private static final int SEATBELT_FINE = 100;
    @Override
    public Violation check(QuRadar radar) {

        if (!radar.isSeatbeltFastened()) {
            return new Violation("Seatbelt not fastened",SEATBELT_FINE);
        }
        return null;
    }
}
