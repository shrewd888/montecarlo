import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PortfolioSimulator {

    private int numOfSimulation;

    //number of year of projecting portfolio future value
    private int numOfYear;

    private Portfolio portfolio;

    private static final double INFLATION_RATE = 0.035;

    //each investment in the list is the x number of year future investment values
    //this is used only if we want to calculate median, 10% best case, 20% worst case without using DescriptiveStatistics
    private List<Double> futureInvestmentValues = new ArrayList<>();

    private NormalDistribution normalDistribution;

    private DescriptiveStatistics statistics;


    public PortfolioSimulator(Portfolio portfolio, int numOfSimulation, int numOfYear) {
        this.portfolio = portfolio;
        this.normalDistribution = new NormalDistribution(portfolio.getPortfolioType().mean, portfolio.getPortfolioType().standardDeviation);
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
     * Run simulation (using Monte Carlo Simulation) of projecting future value over x number of years
     */
    public void simulate() {
        int sim = 0;

        while (sim < numOfSimulation) {
            int year = 0;
            BigDecimal totalInvestment = this.portfolio.getInitialInvestment();
            while (year < numOfYear) {
                double random = getRandomFutureValue();
                //calculate investment based on random future value
                totalInvestment = new BigDecimal(1+random).multiply(totalInvestment);
                //calculate inflation
                totalInvestment = new BigDecimal(1-INFLATION_RATE).multiply(totalInvestment);
                year++;
            }
            //add to the list only if we want to calculate median, 10% best case, 20% worst case without using DescriptiveStatistics
            futureInvestmentValues.add(totalInvestment.doubleValue());

            //save value per simulation to calculate the stats
            this.getStatistics().addValue(totalInvestment.doubleValue());
            sim++;
        }

        this.portfolio.setMedian(this.getStatistics().getPercentile(50));
        this.portfolio.setTenPercentBestCase(this.getStatistics().getPercentile(90));
        this.portfolio.setTenPercentWorstCase(this.getStatistics().getPercentile(10));
    }

    /** Calculate median */
    public double median() {
        int size = futureInvestmentValues.size();
        Collections.sort(futureInvestmentValues);
        return size % 2 == 0 ? futureInvestmentValues.stream().skip(size/2 -1).limit(2).mapToDouble(Double::doubleValue).average().getAsDouble():
                futureInvestmentValues.stream().skip(size/2)
                        .mapToDouble(Double::doubleValue)
                        .findFirst().getAsDouble();
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
