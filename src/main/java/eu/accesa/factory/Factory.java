package eu.accesa.factory;

import eu.accesa.stock.Stock;
import org.springframework.stereotype.Component;

@Component
public class Factory {
    public void initialize(Stock stock) {
        System.out.println("factory");
    }
}
