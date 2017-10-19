class RaindropConverter {

    String convert(int number) {
        final boolean pling = number % 3 == 0;
        final boolean plang = number % 5 == 0;
        final boolean plong = number % 7 == 0;

        if (!(pling || plang || plong))
            return String.valueOf(number);

        return (new StringBuilder())
                .append(pling ? "Pling" : "")
                .append(plang ? "Plang" : "")
                .append(plong ? "Plong" : "")
                .toString();
    }

}
