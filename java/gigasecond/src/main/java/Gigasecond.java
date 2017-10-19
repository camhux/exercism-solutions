import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by cmartin on 5/11/17.
 */
public class Gigasecond {
    private static final long GIGASECOND = (long)Math.pow(10, 9);

    private LocalDateTime birthdate;

    public Gigasecond(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public Gigasecond(LocalDate birthdate) {
        this(birthdate.atStartOfDay());
    }

    public LocalDateTime getDate() {
        return this.birthdate.plusSeconds(GIGASECOND);
    }
}
