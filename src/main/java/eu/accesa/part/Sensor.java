package eu.accesa.part;

public class Sensor extends Part {
    public Sensor(Double price) {
        super(0.01, price);
    }

    public Sensor(Sensor sensor) {
        super(sensor);
    }
}
