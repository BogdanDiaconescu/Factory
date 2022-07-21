package eu.accesa.car.dacia;

import eu.accesa.car.Car;
import eu.accesa.internshipfactory.constatnts.EngineType;
import eu.accesa.part.*;

import java.util.List;

public class Dacia extends Car {

    public Dacia() {
        setBrakes(List.of(new Brake(1)));
        setChassis(new Chassis(1));
        setEngines(List.of(new Engine(EngineType.GASOLINE, 90l, 999d, 1000d)));
        Seat seat = new Seat(100d, false, true, false);
        setSeats(List.of(seat, seat, seat, seat));
        Sensor sensor = new Sensor(50d);
        setSensors(List.of(sensor, sensor));
        setSteeringWheel(new SteeringWheel("ROUND"));
        Wheel wheel = new Wheel(4);
        setWheels(List.of(wheel, wheel, wheel, wheel));
    }

}
