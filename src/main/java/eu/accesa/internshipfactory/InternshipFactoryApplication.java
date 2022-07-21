package eu.accesa.internshipfactory;
import eu.accesa.factory.Factory;
import eu.accesa.sales.Sales;
import eu.accesa.sales.Transaction;
import eu.accesa.stock.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import static eu.accesa.sales.Status.WAITING;

@SpringBootApplication
public class InternshipFactoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(InternshipFactoryApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws IOException {
        Stock stock = new Stock();
        stock.initialize();
        Factory factory = new Factory();
        factory.initialize(stock);
        Sales sales = new Sales();
        sales.initialize(factory);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        boolean moreInput = true;
        while(moreInput){
            String text = console.readLine();
            System.out.println("Introduce your name: ");
            String name = console.readLine();
            System.out.println("Car brands:");
            List<String> brands = factory.getBrands();
            for(String b : brands){
                System.out.println(b);
            }
            String brand = console.readLine();
            List<String> models = factory.getModels(brand);
            for(String m : models){
                System.out.println(m);
            }
            String model = console.readLine();
            if("q".equalsIgnoreCase(text)) {
                moreInput = false;
            }
            Double price = factory.getCarPrice();
            Double transactionPrice = price + price * Sales.getProfitMargin();
            System.out.println("Price for current transaction: " + transactionPrice + "Do you want to proceed? (y/n)");
            Thread t1=new Thread();
            if(!console.readLine().equals("y"))
                System.out.println("Okay. Thank you for your time!");
            else{
                Transaction t = new Transaction( WAITING,true,price, transactionPrice - price, name, model, brand);
                t1.start();
                System.out.println("We've added you on the waiting list!");
                sales.getWaitingTransactions().add(t);
            }
            System.out.println("################## ADMIN SIDE ####################");
            Transaction transaction = sales.getWaitingTransactions().poll();
            if(factory.checkIfCarCanBeMade(transaction.getBrand(), transaction.getModel())){
                System.out.println("Client " + transaction.getClientName() + ". Car in process.");
                sales.getOngoingTransactions().add(transaction);
                factory.start();
            }
            System.out.println("##################################################");
            t1.stop;
        }
        return null;
    }

}