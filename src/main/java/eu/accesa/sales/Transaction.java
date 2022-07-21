package eu.accesa.sales;
public class Transaction implements Runnable {
    private Status status;
    private boolean active;
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

    public void receivePart() {
        synchronized (this) {
            this.notify();
        }
    }
}