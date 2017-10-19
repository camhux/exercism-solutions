import java.util.stream.Stream;

public class Hamming {
    private String stringA;
    private String stringB;

    public Hamming(String stringA, String stringB) {
        if (stringA.length() != stringB.length())
            throw new IllegalArgumentException("Strings passed to Hamming constructor must have equal length");

        this.stringA = stringA;
        this.stringB = stringB;
    }

    public int getHammingDistance() {
        return Stream.of(zipStrings())
                .mapToInt(tuple -> tuple[0] == tuple[1] ? 0 : 1)
                .reduce(0, Integer::sum);
    }

    private char[][] zipStrings() {
        char[][] ret = new char[stringA.length()][2];

        for (int i = 0; i < stringA.length(); i++)
            ret[i] = new char[] { stringA.charAt(i), stringB.charAt(i) };

        return ret;
    }
}
