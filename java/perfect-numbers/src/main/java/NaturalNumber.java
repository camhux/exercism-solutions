import java.util.stream.IntStream;

class NaturalNumber {
    private final int number;

    public NaturalNumber(final int number) {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.number = number;
    }

    public Classification getClassification() {
        final int aliquot = IntStream.rangeClosed(1, number / 2).filter(i -> number % i == 0).sum();

        if (aliquot > number)
            return Classification.ABUNDANT;
        else if (aliquot == number)
            return Classification.PERFECT;
        else
            return Classification.DEFICIENT;
    }
}
