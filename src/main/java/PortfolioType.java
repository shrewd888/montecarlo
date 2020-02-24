public enum PortfolioType {

    Aggressive(0.094324, 0.15675), VeryConservative(0.06189, 0.063438);

    public double mean;
    public double standardDeviation;

    private PortfolioType(double mean, double standardDeviation) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }

    @Override
    public String toString() {
        switch (this) {
            case Aggressive:
                return "Aggressive ("
                        + "mean = " + this.mean
                        + ", standardDeviation = " + this.standardDeviation
                        + ")";
            case VeryConservative:
                return "Very Conservative ("
                        + "mean = " + this.mean
                        + ", standardDeviation = " + this.standardDeviation
                        + ")";
            default: throw new IllegalArgumentException();
        }
    }
}
