package eu.accesa.part;

public class AllWheelDrive extends Part{
    private Integer performance;

    public AllWheelDrive(Integer performance, Double price) {
        super(100.0 * performance, price);
        this.performance = performance;
    }

    public AllWheelDrive(AllWheelDrive allWheelDrive) {
        super(allWheelDrive);
        this.performance = allWheelDrive.getPerformance();
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }
}
