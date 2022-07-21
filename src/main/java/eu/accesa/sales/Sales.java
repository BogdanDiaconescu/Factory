package eu.accesa.sales;

import eu.accesa.factory.Factory;

import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;


public class Sales {
    private Queue<Transaction> ongoingTransactions;
    private Queue<Transaction> waitingTransactions;
    private Queue<Transaction> previousTransactions;
    private static final Double PROFIT_MARGIN = 0.2;
    private Factory factory;
    private BufferedReader console;

    public Sales() {
    }

    public double calculateSalePrice(double factoryPrice, String brand){
        double salePrice = switch (brand) {
            case "Dacia" -> factoryPrice + (factoryPrice * 5 / 100);    //5% commission
            case "Tesla" -> factoryPrice + (factoryPrice * 10 / 100);   //10% commission
            case "BMW" -> factoryPrice + (factoryPrice * 15 / 100);     //15% commission
            default -> 0;
        };
        return salePrice;
    }


    public void initialize(Factory factory) {
        this.factory = factory;
        this.console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("sales");
    }
    public String getBrandFromCustomer() throws IOException {
            List<String> brands = Arrays.asList("BMW", "Dacia", "Tesla");
//            List<String> brands =  factory.getBrands();
            System.out.println("Choose brand:");
            brands.forEach(System.out::println);
            String chosenBrand = this.console.readLine();
            while (!brands.contains(chosenBrand)) {
                System.out.println("Incorrect brand, try again");
                chosenBrand = this.console.readLine();
            }
        return chosenBrand;
    }
    public String getModelFromCustomer(String chosenBrand) throws IOException {
        List<String> models = Arrays.asList("Logan", "Spring");
//            List<String> models =  factory.getModelsFromBrand(chosenBrand);
        System.out.println("Choose model:");
        models.forEach(System.out::println);
        String chosenModel = this.console.readLine();
        while (!models.contains(chosenModel)) {
            System.out.println("Incorrect model, try again");
            chosenModel = console.readLine();
        }
        return chosenModel;
    }

    public boolean checkCarDisponibility(String brand, String model){
//        return factory.checkIfCarCanBeMade(brand, model);
        return true;
    }
}
