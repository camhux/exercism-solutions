import java.util.stream.IntStream;

final class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(final int input) {
        final int sum = (input * (input + 1)) / 2; // Version of childhood Gauss's algorithm

        return sum * sum;
    }

    int computeSumOfSquaresTo(final int input) {
        return IntStream.range(1, input + 1)
                .map(i -> i * i)
                .sum();
    }

    int computeDifferenceOfSquares(final int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
