import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Scrabble {
    private static final Map<String, Integer> letterScores = new HashMap<>();
    static {
        final Object[][] scores = new Object[][]{
                {1, "A", "E", "I", "O", "U", "L", "N", "R", "S", "T"},
                {2, "D", "G"},
                {3, "B", "C", "M", "P"},
                {4, "F", "H", "V", "W", "Y"},
                {5, "K"},
                {8, "J", "X"},
                {10, "Q", "Z"}
        };

        for (Object[] scoreList : scores) {
            final int score = (int)scoreList[0];
            for (int i = 1; i < scoreList.length; i++)
                letterScores.put((String)scoreList[i], score);
        }
    }

    private final String[] letters;

    public Scrabble(String input) {
        if (input == null) {
            input = "";
        }

        this.letters = Stream.of(input)
                .flatMap(s -> Arrays.stream(s.split("")))
                .filter(s -> s.matches("\\w"))
                .map(String::toUpperCase)
                .toArray(String[]::new);
    }

    public int getScore() {
        return Arrays.stream(letters)
                .mapToInt(letter -> letterScores.get(letter))
                .sum();
    }
}
