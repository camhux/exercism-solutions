import java.math.BigInteger;
import java.util.stream.IntStream;

public class SumOfMultiples {
    private int limit;
    private int[] bases;

    public SumOfMultiples(int limit, int[] bases) {
        this.limit = limit;
        this.bases = bases;
    }

    public int getSum() {
        int sum = IntStream.of(bases)
                .map(base -> calculateSequenceSumFor(base))
                .sum();

        int overlap = calculateSequenceSumFor(arrayLcm(bases));

        return sum - overlap;
    }

    private int getSequenceEndFor(int base) {
        int N = limit - 1;

        while ((N % base) != 0 && N > 0) {
            N -= 1;
        }

        return N;
    }

    private int calculateSequenceSumFor(int base) {
        int sequenceEnd = getSequenceEndFor(base);

        return (sequenceEnd / base * (sequenceEnd + base)) / 2;
    }

    private static int arrayGcd(int[] numbers) {
        return IntStream.of(numbers)
                .reduce((a, b) -> {
                    int larger = Math.max(a, b);
                    int smaller = Math.min(a, b);

                    while (larger % smaller != 0) {
                        int r = larger % smaller;
                        larger = smaller;
                        smaller = r;
                    }

                    return smaller;
                })
                .orElse(1);
    }

    private static int arrayLcm(int[] numbers) {
        return IntStream.of(numbers)
                .reduce((a, b) -> a * b)
                .orElse(1)
                / arrayGcd(numbers);
    }
}
