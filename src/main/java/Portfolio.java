import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.math.BigDecimal;

public class Portfolio {

    //name, mean and standardDeviation of portfolio
    private PortfolioType portfolioType;

    private BigDecimal initialInvestment;

    // median over x number year
    private double median;

    // 90 percentile value among the x-times simulations
    private double tenPercentBestCase;

    //10 percentile value among the x-times simulations
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portfolio)) return false;

        Portfolio portfolio = (Portfolio) o;

        if (Double.compare(portfolio.getMedian(), getMedian()) != 0) return false;
        if (Double.compare(portfolio.getTenPercentBestCase(), getTenPercentBestCase()) != 0) return false;
        if (Double.compare(portfolio.getTenPercentWorstCase(), getTenPercentWorstCase()) != 0) return false;
        if (getPortfolioType() != portfolio.getPortfolioType()) return false;
        return getInitialInvestment() != null ? getInitialInvestment().equals(portfolio.getInitialInvestment()) : portfolio.getInitialInvestment() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getPortfolioType() != null ? getPortfolioType().hashCode() : 0;
        result = 31 * result + (getInitialInvestment() != null ? getInitialInvestment().hashCode() : 0);
        temp = Double.doubleToLongBits(getMedian());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTenPercentBestCase());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTenPercentWorstCase());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
