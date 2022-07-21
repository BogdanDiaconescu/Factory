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
import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;

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
        //verify stock

        //add steering wheel
        SteeringWheel steeringWheel= new SteeringWheel(shape);
        currentCar.setSteeringWheel(steeringWheel);

        //return true if added
        return true;
    }

    Boolean addSunRoof(Boolean electric) {
        //verify stock

        //add sunroof if available
        SunRoof sunroof=new SunRoof(electric, 100d);
        currentCar.setSunRoof(sunroof);

        //return true if added sunroof
        return true;
    }

    Boolean addWheel(Integer numberOfSpokes) {
        //verify stock

        //add wheel in the list of wheels if available
        Wheel wheel=new Wheel(numberOfSpokes);
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



