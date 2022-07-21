package eu.accesa.factory;

import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;

@Component
public class Factory {
    public void initialize(Stock stock) {
        System.out.println("factory");
    }

    Boolean checkIfCarCanBeMade(String brand, String model) {
        return true;
    }

    Boolean addAirConditioning() {
        return true;
    }

    Boolean addAllWheelDrive() {
        return true;
    }

    Boolean addAutoPilot() {
        return true;
    }

    Boolean addAirBrake() {
        return true;
    }

    Boolean addAirChassis() {
        return true;
    }

    Boolean addEngine() {
        return true;
    }

    Boolean addPart() {
        return true;
    }

    Boolean addSeat() {
        return true;
    }

    Boolean addSensor() {
        return true;
    }
    Boolean addSteeringWheel() {
        return true;
    }

    Boolean addSunRoof() {
        return true;
    }

    Boolean addWheel() {
        return true;
    }

}
