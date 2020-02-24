import java.math.BigDecimal;

public class Portfolio {

    private PortfolioType portfolioType;

    private BigDecimal initialInvestment;

    private double median;

    private double tenPercentBestCase;

    private double tenPercentWorstCase;

    public Portfolio() {}

    public Portfolio(PortfolioType type, BigDecimal initialInvestment) {
        this.portfolioType = type;
        this.initialInvestment = initialInvestment;
    }

    public PortfolioType getPortfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(PortfolioType portfolioType) {
        this.portfolioType = portfolioType;
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
        return "Portfolio Type [ "
                + this.portfolioType.toString()
                +", Initial Investment = " + initialInvestment
                +", Median = " + median
                +", 10% Best Case = " + tenPercentBestCase
                +", 10% Worst Case = " + tenPercentWorstCase
                +" ]";
    }
}
