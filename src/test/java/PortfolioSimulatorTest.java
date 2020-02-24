import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PortfolioSimulatorTest {

    private static final int NUM_OF_SIMULATION = 10000;
    private static final int NUM_OF_YEAR = 20;
    private static final BigDecimal INITIAL_INVESTMENT = new BigDecimal(100000);

    @Test
    public void testSimulation() {
        for (PortfolioType type : PortfolioType.values()) {
            Portfolio portfolio = new Portfolio(type, INITIAL_INVESTMENT);
            PortfolioSimulator simulator = new PortfolioSimulator(portfolio, NUM_OF_SIMULATION, NUM_OF_YEAR);
            simulator.simulate();
            Assert.assertEquals(simulator.median(), portfolio.getMedian(), 0);
            System.out.println(portfolio);
        }
    }
}
