package eu.accesa.part;

public class Wheel extends Part {

    private Integer numberOfSpokes;

    public Wheel(Integer numberOfSpokes) {
        super(1d * numberOfSpokes, 30d * numberOfSpokes);
        this.numberOfSpokes = numberOfSpokes;
    }

    public Wheel(Wheel wheel) {
        super(wheel);
        this.numberOfSpokes = wheel.getNumberOfSpokes();
    }

    public Integer getNumberOfSpokes() {
        return numberOfSpokes;
    }

    public void setNumberOfSpokes(Integer numberOfSpokes) {
        this.numberOfSpokes = numberOfSpokes;
    }
}
