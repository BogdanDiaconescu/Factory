package eu.accesa.stock;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SteelGenerator {
    private static LocalDateTime lastGenerated = LocalDateTime.now();

    public SteelGenerator() {
        lastGenerated = LocalDateTime.now();
    }

    public Double generate() {
        LocalDateTime now = LocalDateTime.now();
        long seconds = ChronoUnit.SECONDS.between(lastGenerated, now);

        if (seconds > 5) {
            lastGenerated = now;
            return 100d;
        }

        return 0d;
    }
}
