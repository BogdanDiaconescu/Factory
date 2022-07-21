package eu.accesa.part;

public class SteeringWheel extends Part {
    private String shape;

    public SteeringWheel(String shape) {
        super(1d, 100d);
        setShape(shape);
    }

    public SteeringWheel(SteeringWheel steeringWheel) {
        super(steeringWheel);
        this.shape = steeringWheel.getShape();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        if ("ROUND".equalsIgnoreCase(shape) || "yoke".equalsIgnoreCase(shape)) {
            this.shape = shape;
        } else {
            throw new RuntimeException("SteeringWheel can be either Round or Yoke");
        }
    }
}
