package eu.accesa.part;

public class SunRoof extends Part {
    private Boolean electric;

    public SunRoof(Boolean electric, Double price) {
        super(30d, electric ? price * 2 : price);
        this.electric = electric;
    }

    public SunRoof(SunRoof sunRoof) {
        super(sunRoof);
        this.electric = sunRoof.getElectric();
    }

    public Boolean getElectric() {
        return electric;
    }

    public void setElectric(Boolean electric) {
        this.electric = electric;
    }
}
