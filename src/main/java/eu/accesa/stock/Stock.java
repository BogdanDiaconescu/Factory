package eu.accesa.stock;

import eu.accesa.part.Part;

public class Stock {
    public void initialize() {
        System.out.println("stock");
    }
    public Boolean checkIfPartInStock(Part part){
        return true;
    }

    public Boolean takePart(Part part){
        return true;
    }

    public Integer checkPartTimeToCreate(Part part)
    {
        return 1;
    }
}
