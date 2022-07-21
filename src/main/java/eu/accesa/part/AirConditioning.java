package eu.accesa.part;

public class AirConditioning extends Part {

    private Integer vents;

    public AirConditioning(Integer vents) {
        super(0.1 * vents, 100d * vents);
        this.vents = vents;
    }

    public AirConditioning(AirConditioning airConditioning) {
        super(airConditioning);
        this.vents = airConditioning.getVents();
    }

    public Integer getVents() {
        return vents;
    }

    public void setVents(Integer vents) {
        this.vents = vents;
    }
}
