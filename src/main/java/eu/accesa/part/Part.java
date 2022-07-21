package eu.accesa.part;

import java.util.Objects;

public class Part {
    private Double steelContentInKg;
    private Double price;

    public Part(Double steelContentInKg, Double price) {
        this.steelContentInKg = steelContentInKg;
        this.price = price;
    }

    public Part(Part part) {
        this.steelContentInKg = part.getSteelContentInKg();
        this.price = part.getPrice();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public boolean equals(Part o) {
        if(o.getPrice()==this.getPrice() && o.getSteelContentInKg() == this.getSteelContentInKg())
            return true;
        return false;


    }


    public Double getSteelContentInKg() {
        return steelContentInKg;
    }

    public void setSteelContentInKg(Double steelContentInKg) {
        this.steelContentInKg = steelContentInKg;
    }
}
