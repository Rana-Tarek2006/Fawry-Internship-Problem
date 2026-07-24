package src.quantumradar.rules;

import src.quantumradar.model.QuRadar;
import src.quantumradar.model.Violation;

public interface TrafficRule {
    Violation check(QuRadar radar);
}

