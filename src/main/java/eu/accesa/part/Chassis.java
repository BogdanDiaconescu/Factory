package eu.accesa.part;

public class Chassis extends Part {

    private Integer stiffness;

    public Chassis(Integer stiffness) {
        super(100d * stiffness, 200.0 * stiffness);
        this.stiffness = stiffness;
    }

    public Chassis(Chassis chassis) {
        super(chassis);
        this.stiffness = chassis.getStiffness();
    }

    public Integer getStiffness() {
        return stiffness;
    }

    public void setStiffness(Integer stiffness) {
        this.stiffness = stiffness;
    }
}
