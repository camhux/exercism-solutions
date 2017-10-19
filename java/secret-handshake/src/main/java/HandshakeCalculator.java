import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

final class HandshakeCalculator {
    public List<Signal> calculateHandshake(Integer n) {
        return Stream.of(Signal.values())
                .filter(signal -> (1 << signal.ordinal()) > 0)
                .
    }
}
