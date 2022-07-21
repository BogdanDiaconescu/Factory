package eu.accesa.sales;

import eu.accesa.factory.Factory;

import java.util.ArrayList;
import java.util.Scanner;

public class Sales {

    public void initialize(Factory factory) {

        System.out.println("sales");
    }

    public String getBrandFromCustomer( ArrayList <String> cars){
        String brand;
        while (true) {
            System.out.println("What brand do you want?");
            for (String i : cars) {
                System.out.printf(String.format(i, " "));
            }
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            brand = myObj.nextLine();  // Read user input
            if(cars.contains(brand))
            {
            break;
            }
            else System.out.println("Invalid input, try again");
        }
        return brand;

    }
    public String getTypeFromCustomers (String brand)
    {  String typecar;
        while(true){
        System.out.println("What type do you want?");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("You must chose brand:" + brand);
        System.out.println("You have types from this brand:");
        ArrayList <String> types=Factory.getModels(brand);
        for (String i : types)
            System.out.printf(String.format(i, " "));
            typecar = myObj.nextLine();  // Read user input
            if(types.contains(typecar))
                break;
            else System.out.println("Invalid input, try again");
    }
        return typecar;
    }



}
