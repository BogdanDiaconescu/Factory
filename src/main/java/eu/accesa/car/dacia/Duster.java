package eu.accesa.car.dacia;

import eu.accesa.part.AllWheelDrive;
import eu.accesa.part.Brake;

import java.util.List;

public class Duster extends Dacia {

    public Duster() {
        setAllWheelDrive(new AllWheelDrive(1, 1000d));
        Brake brake = new Brake(1);
        setBrakes(List.of(brake, brake));
        setRange(800d);
    }
}
