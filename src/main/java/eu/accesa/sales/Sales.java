package eu.accesa.sales;

import eu.accesa.factory.Factory;

import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sales {
    private Factory factory;
    private BufferedReader console;


    public void initialize(Factory factory) {
        this.factory = factory;
        this.console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("sales");
    }
    public String getBrandFromCustomer() throws IOException {
            System.out.println("client nou...");
            List<String> brands = Arrays.asList("BMW", "Dacia", "Tesla");
//            List<String> brands =  factory.getBrands();
            System.out.println("Alege brandul:");
            brands.forEach(System.out::println);
            String chosenBrand = this.console.readLine();
            while (!brands.contains(chosenBrand)) {
                System.out.println("Brand indisponibil, mai incearca");
                chosenBrand = this.console.readLine();
            }
        return chosenBrand;
    }
    public String getModelFromCustomer(String chosenBrand) throws IOException {
        List<String> models = Arrays.asList("Logan", "Spring");
//            List<String> models =  factory.getModelsFromBrand(chosenBrand);
        System.out.println("Alege modelul:");
        models.forEach(System.out::println);
        String chosenModel = this.console.readLine();
        while (!models.contains(chosenModel)) {
            System.out.println("Model indisponibil, mai incearca");
            chosenModel = console.readLine();
        }
        return chosenModel;
    }

    public boolean checkCarDisponibility(String brand, String model){
//        return factory.checkIfCarCanBeMade(brand, model);
        return true;
    }
}
