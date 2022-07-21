package eu.accesa.internshipfactory;

import eu.accesa.factory.Factory;
import eu.accesa.sales.Sales;
import eu.accesa.stock.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
            if("q".equalsIgnoreCase(text)) {
                moreInput = false;
            }
        }

        return null;
    }

}