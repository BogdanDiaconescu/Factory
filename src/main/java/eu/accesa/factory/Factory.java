package eu.accesa.factory;

import eu.accesa.internshipfactory.constatnts.EngineType;
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

    Boolean addAirConditioning(Integer vents) {
        return true;
    }

    Boolean addAllWheelDrive(Integer performance) {
        return true;
    }

    Boolean addAutoPilot(Integer level) {
        return true;
    }

    Boolean addBrake(Integer performance) {
        return true;
    }

    Boolean addChassis(Integer stiffness) {
        return true;
    }

    Boolean addEngine(EngineType type, Long horsePower, Double cylinderCapacity) {
        return true;
    }

    Boolean addSeat(Boolean heated, Boolean manual, Boolean electric) {
        return true;
    }

    Boolean addSensor() {
        return true;
    }
    Boolean addSteeringWheel(String shape) {
        return true;
    }

    Boolean addSunRoof(Boolean electric) {
        return true;
    }

    Boolean addWheel(Integer numberOfSpokes) {
        return true;
    }

}
