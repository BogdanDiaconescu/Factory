package eu.accesa.stock;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SteelGenerator {
    private static LocalDateTime lastGenerated;

    private static Double generate() {
        LocalDateTime now = LocalDateTime.now();
        Long seconds = ChronoUnit.SECONDS.between(lastGenerated, now);
        if (seconds > 30) {
            return 100d;
        }
        return null;
    }

}
