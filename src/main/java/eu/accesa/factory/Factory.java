package eu.accesa.factory;


import eu.accesa.internshipfactory.constatnts.EngineType;

import eu.accesa.car.Car;

import eu.accesa.part.AirConditioning;
import eu.accesa.part.AllWheelDrive;
import eu.accesa.part.AutoPilot;
import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Factory {
    private Car currentCar;
    public void initialize(Stock stock) {
        System.out.println("factory");
    }

    Boolean checkIfCarCanBeMade(String brand, String model) {
        currentCar = new Car();
        return true;
    }

    Boolean addAirConditioning(Integer vents) {
        // verify stock
        currentCar.setAirConditioning(new AirConditioning(vents));
        return true;
    }

    Boolean addAllWheelDrive(Integer performance) {
        // verify stock
        currentCar.setAllWheelDrive(new AllWheelDrive(performance,0.0));
        return true;
    }

    Boolean addAutoPilot(Integer level) {
        // verify stock
        currentCar.setAutoPilot(new AutoPilot(level));
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



    public ArrayList<Object> offerTypes(Object o){

        ArrayList<Object> types = new ArrayList<>();
        for(Object obj: o.getClass().getClasses()) {

            types.add(o.getClass().getName());
        }
        return types;
    }



    }



