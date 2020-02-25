import java.math.BigDecimal;

public class Portfolio {

    private String name;

    private double mean;

    private double standardDeviation;

    private BigDecimal initialInvestment;

    private double median;

    private double tenPercentBestCase;

    private double tenPercentWorstCase;


    public Portfolio() {}

    public Portfolio(String name, double mean, double standardDeviation, BigDecimal initialInvestment) {
        this.name = name;
        this.mean = mean;
        this.standardDeviation = standardDeviation;
        this.initialInvestment = initialInvestment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public BigDecimal getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(BigDecimal initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getTenPercentBestCase() {
        return tenPercentBestCase;
    }

    public void setTenPercentBestCase(double tenPercentBestCase) {
        this.tenPercentBestCase = tenPercentBestCase;
    }

    public double getTenPercentWorstCase() {
        return tenPercentWorstCase;
    }

    public void setTenPercentWorstCase(double tenPercentWorstCase) {
        this.tenPercentWorstCase = tenPercentWorstCase;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (mean=").append(mean).append(", standardDeviation=").append(standardDeviation).append(")")
                .append(System.getProperty("line.separator"));
        sb.append("Initial Investment=").append(initialInvestment).append(System.getProperty("line.separator"));
        sb.append("Median 20 Year=").append(median).append(", 10% Best Case=").append(tenPercentBestCase).append(", 10% Worst Case=").append(tenPercentWorstCase);
        return sb.toString();
    }
}
