public class Twofer {
    private static String formatString = "One for %s, one for me.";

    public String twofer(String name) {
        String value = "you";

        if (name != null) {
            value = name;
        }

        return String.format((formatString), value);
    }
}