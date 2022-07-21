package eu.accesa.part;

public class AutoPilot extends Part {

    // 0 - 5 (degree of autonomy)
    private Integer level;

    public AutoPilot(Integer level) {
        super(0d, 2500d * level);
        this.level = level;
    }

    public AutoPilot(AutoPilot autoPilot) {
        super(autoPilot);
        this.level = autoPilot.getLevel();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
