public class SpaceAge {
    private long seconds;

    public SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }

    public double onMercury() {
        return spaceAgeForPlanet(Planet.MERCURY);
    }

    public double onVenus() {
        return spaceAgeForPlanet(Planet.VENUS);
    }

    public double onEarth() {
        return spaceAgeForPlanet(Planet.EARTH);
    }

    public double onMars() {
        return spaceAgeForPlanet(Planet.MARS);
    }

    public double onJupiter() {
        return spaceAgeForPlanet(Planet.JUPITER);
    }

    public double onSaturn() {
        return spaceAgeForPlanet(Planet.SATURN);
    }

    public double onUranus() {
        return spaceAgeForPlanet(Planet.URANUS);
    }

    public double onNeptune() {
        return spaceAgeForPlanet(Planet.NEPTUNE);
    }

    private static final long YEAR = 31557600;

    private double spaceAgeForPlanet(Planet planet) {
        return seconds / (YEAR * planet.yearRatioToEarth);
    }

    private enum Planet {
        MERCURY(0.2408467),
        VENUS(0.61519726),
        EARTH(1),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private double yearRatioToEarth;

        Planet(double yearRatioToEarth) {
            this.yearRatioToEarth = yearRatioToEarth;
        }
    }
}
