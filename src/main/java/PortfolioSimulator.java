import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PortfolioSimulator {

    private int numOfSimulation;

    //number of year of projecting portfolio future value
    private int numOfYear;

    private Portfolio portfolio;

    private NormalDistribution normalDistribution;

    private DescriptiveStatistics statistics;

    public PortfolioSimulator(Portfolio portfolio, int numOfSimulation, int numOfYear) {
        this.portfolio = portfolio;
        this.normalDistribution = new NormalDistribution(portfolio.getMean(), portfolio.getStandardDeviation());
        this.statistics = new DescriptiveStatistics();
        this.numOfSimulation = numOfSimulation;
        this.numOfYear = numOfYear;
    }

    /**
     * Get random value based on portfolio's standard deviation and return (mean)
     */
    public double getRandomFutureValue() {
        return this.getNormalDistribution().sample();
    }

    /**
     * Run Monte Carlo Simulation of projecting future value over x number of years using simple calculation
     * Take the random generated rate minus the inflation rate to be equal to the inflation adjustment rate
     *
     * For example:
     * Assumption: the rate of return is 9% every year
     * Year 1:
     * Investment: $100,000 Return: 9%, Inflation: 3.5%, End of Year: $109,000, EOY Inflation: $3500, EOY Inflation Adjusted: $105,500
     * Year 2:
     * Investment: $105,500 Return: 9%, Inflation: 3.5%, End of Year: $114,995, EOY Inflation: $3693, EOY Inflation Adjusted: $111,303
     * Year 3:
     * Investment: $111,303 Return: 9%, Inflation: 3.5%, End of Year: $121,320, EOY Inflation: $3896, EOY Inflation Adjusted: $117,424
     *
     * Note:
     * Below is the article to calculate returns on investments with inflation the more precise way:
     * https://finance.zacks.com/calculate-returns-investments-inflation-1850.html
     */
    public void simulateWithInflation(double inflationRate) {
        int sim = 0;

        while (sim < numOfSimulation) {
            int year = 0;
            BigDecimal totalInvestment = this.portfolio.getInitialInvestment();

            while (year < numOfYear) {
                double random = getRandomFutureValue();
                totalInvestment = new BigDecimal(1 + (random-inflationRate)).multiply(totalInvestment);
                year++;
            }
             //save value per simulation to calculate the stats
            this.getStatistics().addValue(totalInvestment.doubleValue());
            sim++;
        }
        this.portfolio.setMedian(this.getStatistics().getPercentile(50));
        this.portfolio.setTenPercentBestCase(this.getStatistics().getPercentile(90));
        this.portfolio.setTenPercentWorstCase(this.getStatistics().getPercentile(10));
    }

    public NormalDistribution getNormalDistribution() {
        return normalDistribution;
    }

    public void setNormalDistribution(NormalDistribution normalDistribution) {
        this.normalDistribution = normalDistribution;
    }

    public DescriptiveStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(DescriptiveStatistics statistics) {
        this.statistics = statistics;
    }
}
