package eu.accesa.car.dacia;

import eu.accesa.internshipfactory.constatnts.EngineType;
import eu.accesa.part.Engine;
import eu.accesa.part.Sensor;

import java.util.List;

public class Spring extends Dacia {

    public Spring() {
        setEngines(List.of(new Engine(EngineType.ELECTRIC, 45l, null, 3500d)));
        setRange(200d);
        Sensor sensor = new Sensor(50d);
        setSensors(List.of(sensor, sensor, sensor, sensor));
    }
}
