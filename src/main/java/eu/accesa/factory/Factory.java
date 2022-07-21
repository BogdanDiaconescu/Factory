package eu.accesa.factory;


import eu.accesa.internshipfactory.constatnts.EngineType;

import eu.accesa.car.Car;

import eu.accesa.part.Brake;
import eu.accesa.part.Chassis;
import eu.accesa.part.Engine;
import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        return true;
    }

    Boolean addAllWheelDrive(Integer performance) {
        return true;
    }

    Boolean addAutoPilot(Integer level) {
        return true;
    }

    Boolean addBrake(Integer performance) {

        Brake b = new Brake(performance);
        ArrayList<Brake> list = new ArrayList();

        list.add(b);

        //stock checking in the future
        if(true){
            currentCar.setBrakes(list);
            return false;
        }
        return false;
    }

    Boolean addChassis(Integer stiffness) {

        Chassis c = new Chassis(stiffness);

        //stock checking in the future
        if(true){
            currentCar.setChassis(c);
            return true;
        }

        return false;
    }

    Boolean addEngine(EngineType type, Long horsePower, Double cylinderCapacity, Double price ) {

        Engine e = new Engine(type,horsePower, cylinderCapacity, 0.0);

        if(/*verificare*/true)
        {
            currentCar.setEngines((List<Engine>) e);
            return true;
        }
        else
        {
            return false;
        }
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



