import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class PortfolioSimulatorTest {

    private static final int NUM_OF_SIMULATION = 10000;
    private static final int NUM_OF_YEAR = 20;
    private static final BigDecimal INITIAL_INVESTMENT = new BigDecimal(100000);
    private static final double INFLATION_RATE = 0.035;
    private static final Portfolio AGGRESSIVE = new Portfolio("Aggressive", 0.094324, 0.15675, INITIAL_INVESTMENT);
    private static final Portfolio VERY_CONSERVATIVE = new Portfolio("Very Conservative", 0.06189, 0.063438, INITIAL_INVESTMENT);

    @Test
    public void testSimulationWithoutInflation() {
        System.out.println("*** Portfolio Values Without Inflation from Simulation ***\n");

        List<Portfolio> portfolioList = List.of(AGGRESSIVE, VERY_CONSERVATIVE);
        for (Portfolio portfolio : portfolioList) {
            PortfolioSimulator simulator = new PortfolioSimulator(portfolio, NUM_OF_SIMULATION, NUM_OF_YEAR);
            simulator.simulateWithInflation(0);
            System.out.println(portfolio+"\n");
        }
    }

    @Test
    public void testSimulationWithInflation() {
        System.out.println("*** Portfolio Inflation Adjusted Values from Simulation *** \n");

        List<Portfolio> portfolioList = List.of(AGGRESSIVE, VERY_CONSERVATIVE);
        for (Portfolio portfolio : portfolioList) {
            PortfolioSimulator simulator = new PortfolioSimulator(portfolio, NUM_OF_SIMULATION, NUM_OF_YEAR);
            simulator.simulateWithInflation(INFLATION_RATE);
            System.out.println(portfolio+"\n");
        }
    }
}
