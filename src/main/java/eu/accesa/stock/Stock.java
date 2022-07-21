package eu.accesa.stock;

import eu.accesa.internshipfactory.constatnts.Constants;
import eu.accesa.internshipfactory.constatnts.Parts;
import eu.accesa.part.Part;

import java.util.*;

public class Stock {
    private Double steel;
    // otel, pret, cantitate
    private List<List<Double>> parts;
    private SteelGenerator steelGenerator;

    public void initialize() {
        steelGenerator = new SteelGenerator();

        System.out.println("stock initializer");
        parts = new ArrayList<>();
        parts.add(List.of(10.3d, 4d, 3d));
        parts.add(List.of(10.3d, 4d, 5d));
        parts.add(List.of(12d, 4d, 5d));
        parts.add(List.of(13d, 3d, 5d));
        parts.add(List.of(14.3d, 4d, 5d));

        this.setSteel(Constants.INITIAL_STEEL);
    }

    public void setSteel(Double steel) {
        this.steel = steel;
    }

    public Boolean checkIfPartInStock(Part part) {
        // check if the part is in stock list
        boolean response = false;
        for (List<Double> miniPart : parts) {
            if (Objects.equals(miniPart.get(0), part.getSteelContentInKg()) &&
                    Objects.equals(miniPart.get(1), part.getPrice()) && miniPart.get(2) > 0) {
                response = true;
            }
        }

        if (part.getSteelContentInKg() <= steel) {
            response = true;
        }

        return response;
    }

    public Double getSteel() {
        return steel;
    }

    public Boolean takePart(Part part) {
        boolean ok = false;

        for (List<Double> miniPart : parts) {
            if (Objects.equals(miniPart.get(0), part.getSteelContentInKg()) &&
                    Objects.equals(miniPart.get(1), part.getPrice()) && miniPart.get(2) > 0) {
                miniPart.set(2, miniPart.get(2) - 1);
                ok = true;
            }
        }

        if (!ok && steel >= part.getSteelContentInKg()) {
            steel -= part.getSteelContentInKg();
            ok = true;
        }
        /*
        else {
            if(steel < part.getSteelContentInKg()) {
                while (steel < part.getSteelContentInKg()) {
                    Double d = steelGenerator.generate();
                    if (d != 0d)
                        System.out.println(d);

                    steel += steelGenerator.generate();
                    //System.out.println(steel);
                }
                ok=true;
            }
        }

         */

        return ok;
    }

    public Integer checkPartTimeToCreate(Part part) {
        double requiredSteel = part.getSteelContentInKg() - steel;
        if(requiredSteel < 0) {
            return 0;
        } else {
            return (int) requiredSteel * 30 / 100;
        }
    }
}
