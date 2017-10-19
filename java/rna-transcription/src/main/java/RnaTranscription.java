import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RnaTranscription {
    public String ofDna(String dnaString) {
        if (dnaString.isEmpty()) return "";

        return Stream.of(dnaString.split(""))
                    .map(Rna::fromDna)
                    .map(Rna::toString)
                    .collect(Collectors.joining());
    }

    private enum Rna {
        G,
        C,
        A,
        U;

        private static Map<String, Rna> dnaNucleotideToRna = new HashMap<>();
        static {
            dnaNucleotideToRna.put("C", G);
            dnaNucleotideToRna.put("G", C);
            dnaNucleotideToRna.put("T", A);
            dnaNucleotideToRna.put("A", U);
        }

        public static Rna fromDna(String dnaCharacter) {
            return dnaNucleotideToRna.get(dnaCharacter);
        }
    }
}