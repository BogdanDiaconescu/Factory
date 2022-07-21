package eu.accesa.part;

import eu.accesa.internshipfactory.constatnts.EngineType;

public class Engine extends Part {
    private EngineType type;
    private Long horsePower;
    private Double cylinderCapacity;

    public Engine(EngineType type, Long horsePower, Double cylinderCapacity, Double price) {
        super(150d, price);
        this.type = type;
        this.horsePower = horsePower;
        this.cylinderCapacity = cylinderCapacity;
    }

    public Engine(Engine engine) {
        super(engine);
        this.type = engine.getType();
        this.horsePower = engine.getHorsePower();
        this.cylinderCapacity = engine.getCylinderCapacity();
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public Long getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Long horsePower) {
        this.horsePower = horsePower;
    }

    public Double getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Double cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }
}
