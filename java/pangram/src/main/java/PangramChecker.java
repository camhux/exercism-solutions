import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class PangramChecker {

    public boolean isPangram(String input) {
        for (Character character : input.toCharArray())
            recordCharacter(character);

        return allCharactersRecorded();
    }

    private Set<Character> seenChars = new HashSet<>();

    private void recordCharacter(char character) {
        seenChars.add(Character.toLowerCase(character));
    }

    private boolean allCharactersRecorded() {
        return seenChars.containsAll(alphabet);
    }


    private static Set<Character> alphabet = new HashSet<>(26);
    static {
        for (Character character : "abcdefghijklmnopqrstuvwxyz".toCharArray())
            alphabet.add(character);
    }
}
