import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Acronym {

    private String phrase;

    public Acronym(String phrase) { this.phrase = phrase; }

    public String get() {
        final SortedMap<Integer, String> matches = new TreeMap<>();

        for (AcronymPattern pattern : AcronymPattern.values())
            pattern.executeWith(phrase, matches);

        return matches.values().stream().collect(Collectors.joining());
    }

    private enum AcronymPattern {
        HEAD("^([A-Z])[a-z]*?\\b"),
        POST_BOUNDARY("\\b(\\w)"),
        CAMEL_HUMP("[a-z]([A-Z])");

        final Pattern pattern;

        AcronymPattern(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        void executeWith(CharSequence string, SortedMap<Integer, String> matches) {
            Matcher matcher = this.pattern.matcher(string);

            while (matcher.find()) {
                matches.put(matcher.start(), matcher.group(1).toUpperCase());
            }
        }
    }
}
