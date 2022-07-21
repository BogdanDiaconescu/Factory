package eu.accesa.factory;


import eu.accesa.internshipfactory.constatnts.EngineType;

import eu.accesa.car.Car;



import eu.accesa.part.Brake;
import eu.accesa.part.Chassis;

import eu.accesa.part.AirConditioning;
import eu.accesa.part.AllWheelDrive;
import eu.accesa.part.AutoPilot;
import eu.accesa.part.Engine;
import eu.accesa.part.SteeringWheel;
import eu.accesa.part.SunRoof;
import eu.accesa.part.Wheel;

import eu.accesa.part.*;


import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class Factory {
    private Car currentCar;
    private Stock stock;
    public void initialize(Stock stock) {
        System.out.println("factory");
        this.stock = stock;
    }

    Boolean checkIfCarCanBeMade(String brand, String model) {
        currentCar = new Car();
        return true;
    }

    Boolean addAirConditioning(Integer vents) {
        AirConditioning part = new AirConditioning(vents);
        if(!stock.checkIfPartInStock(part)) {
            return false;
        }
        currentCar.setAirConditioning(part);
        return true;
    }

    Boolean addAllWheelDrive(Integer performance) {
        AllWheelDrive part = new AllWheelDrive(performance,0.0);
        if(!stock.checkIfPartInStock(part)) {
            return false;
        }
        currentCar.setAllWheelDrive(part);
        return true;
    }

    Boolean addAutoPilot(Integer level) {
        AutoPilot part = new AutoPilot(level);
        if(!stock.checkIfPartInStock(part)) {
            return false;
        }
        currentCar.setAutoPilot(part);
        return true;
    }

    Boolean addBrake(Integer performance) {

        Brake b = new Brake(performance);
        ArrayList<Brake> list = new ArrayList();

        list.add(b);

        if(stock.checkIfPartInStock(b)){
            currentCar.setBrakes(list);
            return false;
        }
        return false;
    }

    Boolean addChassis(Integer stiffness) {

        Chassis c = new Chassis(stiffness);

        if(stock.checkIfPartInStock(c)){
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

    Boolean addSeat(Double price ,Boolean heated, Boolean manual, Boolean electric) {
        if(/*verificare*/true)
        {
            currentCar.setSeats((List<Seat>) new Seat(price, heated, manual, electric));
            return true;
        }
        else
        {
            return false;
        }
    }

    Boolean addSensor(Double price) {
        if(/*verificare*/true)
        {
            currentCar.setSensors((List<Sensor>) new Sensor(price));
            return true;
        }
        else
        {
            return false;
        }
    }
    Boolean addSteeringWheel(String shape) {
        //verify stock
        SteeringWheel steeringWheel= new SteeringWheel(shape);
        if (Stock.checkIfPartInStock(steeringWheel)==false)
            return false;

        //add steering wheel
        currentCar.setSteeringWheel(steeringWheel);

        //return true if added
        return true;
    }

    Boolean addSunRoof(Boolean electric) {
        //verify stock
        SunRoof sunroof=new SunRoof(electric, 100d);
        if (Stock.checkIfPartInStock(sunroof)==false)
            return false;

        //add sunroof if available
        currentCar.setSunRoof(sunroof);

        //return true if added sunroof
        return true;
    }

    Boolean addWheel(Integer numberOfSpokes) {
        //verify stock
        Wheel wheel=new Wheel(numberOfSpokes);
        if (Stock.checkIfPartInStock(wheel)==false)
            return false;

        //add wheel in the list of wheels if available
        Queue wheels = (Queue) currentCar.getWheels();
        if (currentCar.getWheels().size()<4)
            wheels.add(wheel);
        else {
            wheels.remove();
            wheels.add(wheel);
        }
        currentCar.setWheels((List<Wheel>) wheels);

        //return true if added wheels
        return true;
    }



    public ArrayList<String> getCars(){

        ArrayList<String> types = new ArrayList<>();
        types.add("Dacia");
        types.add("Tesla");
        types.add("BMW");

        return types;


    }

    public ArrayList<String> getModels(String car){

        ArrayList<String> types = new ArrayList<>();

        switch (car){
            case "Dacia" : {
                types.add("Duster");
                types.add("Logan");
                types.add("Spring");
                break;
            }
            case "BMW" : {
                types.add("Series1");
                types.add("Series3");
                break;
            }
            case "Tesla" : {
                types.add("Model3");
                types.add("ModelS");

                break;
            }

        }
        return types;
    }

    public ArrayList<String> offerTypes(Object o){

        ArrayList<String> types = new ArrayList<>();
        for(Object obj: o.getClass().getClasses()) {

            types.add(obj.getClass().getSimpleName());
        }

        return types;
    }



}



