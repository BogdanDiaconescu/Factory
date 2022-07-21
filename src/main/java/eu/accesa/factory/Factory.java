package eu.accesa.factory;


import eu.accesa.internshipfactory.constatnts.EngineType;

import eu.accesa.car.Car;

import eu.accesa.part.AirConditioning;
import eu.accesa.part.AllWheelDrive;
import eu.accesa.part.AutoPilot;

import eu.accesa.part.Engine;

import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;
import java.lang.reflect.*;

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



    public ArrayList<String> getTypes(String car){

        ArrayList<String> types = new ArrayList<>();


        switch (car){
            case "car" : {
                types.add("bmw");
                types.add("dacia");
                types.add("tesla");
                break;
            }
            case "dacia" : {
                types.add("Dacia");
                types.add("Duster");
                types.add("Logan");
                types.add("Spring");
                break;
            }
            case "bmw" : {
                types.add("Bmw");
                types.add("Series1");
                types.add("Series3");
                break;
            }
            case "tesla" : {
                types.add("Model3");
                types.add("ModelS");
                types.add("Tesla");
                break;
            }

        }
        return types;

    }

    public ArrayList<String> offerTypes(Object o){

        ArrayList<String> types = new ArrayList<>();
        for(Object obj: o.getClass().getClasses()) {

            types.add(obj.getClass().getName());
        }

        return types;
    }



    }



