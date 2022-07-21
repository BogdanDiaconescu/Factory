package eu.accesa.part;

public class Brake extends Part {
    private Integer performance;

    public Brake(Integer performance) {
        super(1.5 * performance, 200.0 * performance);
        setPerformance(performance);
    }

    public Brake(Brake brake) {
        super(brake);
        this.performance = brake.getPerformance();
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        if (performance > 3) {
            performance = 3;
        } else if (performance < 1) {
            performance = 1;
        }
        this.performance = performance;
    }
}
