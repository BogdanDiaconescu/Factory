package eu.accesa.stock;

import eu.accesa.internshipfactory.constatnts.Constants;
import eu.accesa.internshipfactory.constatnts.Parts;
import eu.accesa.part.Part;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Stock {

    private Double steel;
    private Map<Parts, List<Part>> parts;

    private SteelGenerator steelGenerator;

    private Queue<Part> partQueue;

    public void initialize() {
        System.out.println("stock");
        this.setSteel(Constants.INITIAL_STEEL);


    }



    public Double getSteel() {
        return steel;
    }

    public void setSteel(Double steel) {
        this.steel = steel;
    }

    public Map<Parts, List<Part>> getParts() {
        return parts;
    }

    public void setParts(Map<Parts, List<Part>> parts) {
        this.parts = parts;
    }

}
