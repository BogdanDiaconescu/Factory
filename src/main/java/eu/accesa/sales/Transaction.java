package eu.accesa.sales;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Runnable, Comparable<Transaction> {
    private Status status;
    private boolean active;
    private Double price;
    private Double profit;
    private String clientName;
    private String model;
    private String brand;
    public Transaction(Status status) {
        this.status = status;
        active = true;
    }



    @Override
    public void run() {
        while (active) {
            if (status.equals(Status.WAITING))
                synchronized (this) {
                    try {
                        this.wait();
                        status = Status.ONGOING;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            else if (status.equals(Status.ONGOING)) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            status = Status.PREVIOUS;
            active = false;
        }

    }