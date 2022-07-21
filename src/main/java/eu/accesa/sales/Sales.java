package eu.accesa.sales;

import eu.accesa.factory.Factory;
import lombok.Getter;

import java.util.*;
@Getter
public class Sales {
    Scanner scanner=new Scanner(System.in);

    private Queue<Transaction> ongoingTransactions;
    private Queue<Transaction> waitingTransactions;
    private Queue<Transaction> previousTransactions;
    private static final Double PROFIT_MARGIN = 0.2;
    public Sales(){
        ongoingTransactions = new PriorityQueue<>();
        waitingTransactions = new LinkedList<>();
        previousTransactions = new LinkedList<>();
    }
    public void initialize(Factory factory) {
        System.out.println("sales");
    }
    public static Double getProfitMargin() {
        return PROFIT_MARGIN;
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
        ArrayList <String> types=Factory.getModel(brand);
        for (String i : types)
            System.out.printf(String.format(i, " "));
            typecar = myObj.nextLine();  // Read user input
            if(types.contains(typecar))
                break;
            else System.out.println("Invalid input, try again");
    }
        return typecar;
    }
    // CERERILE CUSTOM DE LA CLIENTI:
    public Integer getCustomVents(){
        System.out.println("Introduceti numarul gurilor de aerisire:");
        return scanner.nextInt();
    }

    public Integer getCustomAllWheelDrive(){
        System.out.println("Introduceti performanta sistemului All-Wheel Drive:");
        return scanner.nextInt();
    }

    public Integer getCustomAutoPilotLevel(){
        System.out.println("Introduceti level-ul AutoPilotului: ");
        return scanner.nextInt();
    }

    public Integer getCustomBreakPerformance(){
        System.out.println("Introduceti performanta dorita:");
        return scanner.nextInt();
    }

    public Integer getCustomStiffness(){
        System.out.println("Introduceti rigiditatea dorita:");
        return scanner.nextInt();
    }

    public String getCustomShape(){
        System.out.println("Introduceti forma volanului:");
        return scanner.nextLine();
    }

    public Integer getCustomNumberOfSpokes(){
        System.out.println("Introduceti numarul de spite: ");
        return scanner.nextInt();
    }


}
