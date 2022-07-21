package eu.accesa.factory;


import eu.accesa.car.bmw.Series1;
import eu.accesa.car.bmw.Series3;
import eu.accesa.car.dacia.Duster;
import eu.accesa.car.dacia.Logan;
import eu.accesa.car.dacia.Spring;
import eu.accesa.car.tesla.Model3;
import eu.accesa.car.tesla.ModelS;
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
import java.util.Objects;
import java.util.Queue;

@Component
public class Factory {
    private Car currentCar;
    private Stock stock;
    public void initialize(Stock stock) {
        System.out.println("factory");
        this.stock = stock;
    }
////<<<<<<< sales_andrei
//    //public Boolean checkIfCarCanBeMade(String brand, String model) {
//        currentCar = new Car();
//=======
    public Boolean checkIfCarCanBeMade(String brand, String model) {
        if (Objects.equals(brand, "Dacia")) {
            switch (model) {
                case "Duster" -> currentCar = new Duster();
                case "Logan" -> currentCar = new Logan();
                case "Spring" -> currentCar = new Spring();
            }
        } else if (Objects.equals(brand, "BMW")){
            switch (model) {
                case "Series1" -> currentCar = new Series1();
                case "Series3" -> currentCar = new Series3();

            }
        } else if (Objects.equals(brand, "Tesla")) {
            switch (model) {
                case "Model3" -> currentCar = new Model3();
                case "ModelS" -> currentCar = new ModelS();
            }
        }
        var parts = currentCar.getParts();
        for(var part: parts.values()) {
            for (var part2: part) {
                if (!stock.checkIfPartInStock(part2)) {
                    return false;
                }
            }
        }
//>>>>>>> main
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
            return true;
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

        if(stock.checkIfPartInStock(e))
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
        Seat s= new Seat(price, heated, manual, electric);
        if(stock.checkIfPartInStock(s))
        {
            currentCar.setSeats((List<Seat>) s );
            return true;
        }
        else
        {
            return false;
        }
    }

    Boolean addSensor(Double price) {
        Sensor s=new Sensor(price);
        if(stock.checkIfPartInStock(s))
        {
            currentCar.setSensors((List<Sensor>) s);
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
        if (stock.checkIfPartInStock(steeringWheel)==false)
            return false;

        //add steering wheel
        currentCar.setSteeringWheel(steeringWheel);

        //return true if added
        return true;
    }

    Boolean addSunRoof(Boolean electric) {
        //verify stock
        SunRoof sunroof=new SunRoof(electric, 100d);
        if (stock.checkIfPartInStock(sunroof)==false)
            return false;

        //add sunroof if available
        currentCar.setSunRoof(sunroof);

        //return true if added sunroof
        return true;
    }

    Boolean addWheel(Integer numberOfSpokes) {
        //verify stock
        Wheel wheel=new Wheel(numberOfSpokes);
        if (stock.checkIfPartInStock(wheel)==false)
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



