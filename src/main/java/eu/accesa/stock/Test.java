package eu.accesa.stock;

import eu.accesa.part.Part;

public class Test {
    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.initialize();

        if (stock.checkIfPartInStock(new Part(3.3d, 4d))) {
            System.out.println("dadadad");
        }

        stock.takePart(new Part(3000d, 4d));
        System.out.println(stock.getSteel());
        System.out.println(stock.takePart(new Part(120d, 4d)));
    }
}
