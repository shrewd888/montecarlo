# montecarlo
Modern Portfolio Theory says that it is not enough to look at the expected risk and return of one particular stock. 
By investing in more than one stock, an investor can reap the benefits of diversification- chief among them, a reduction in the riskiness of the portfolio. 
A Real Time implementation of Modern Portfolio Theory is to build an optimal asset allocation of domestic stocks &amp;amp; bonds, international stock and bonds, alternatives and cash. 
Combining the risk &amp;amp; return of each asset class and correlations across them – we come up with the risk and return of the overall portfolio.  
Two portfolios were created, one being extremely Conservative and one being Aggressive. 

| Portfolio Type | Return (Mean)  | Risk (Standard Deviation) |
| ------------- | ------------- | ------------- |
| Aggressive    |  %9.4324   |       15.675      |
| Very Conservative  | %6.189   |     6.3438     |

We would now like to compare their performance against each other. 
We would like to know that if a user with $100,000 invested their money in either of them, how would the returns compare over the next 20 years. We would like to test their performance by using forward- looking Monte Carlo Simulations. 

Monte Carlo Simulation: 
This is a statistical technique that uses pseudo-random uniform variables for a given statistical distribution based on past risk (SD) and return (mean) to predict outcomes over future time periods. 
Based on iterative evaluation of each random future value, we project the portfolio future value over 20 years. 
We would like to run 10,000 simulations of projecting 20 year value and come up with the following: 

Assumptions 
1. We would like to use a random number generator to ensure Gaussian distribution of random numbers that are generated. 
2. 20 th Year future value should be inflation adjusted at the rate of 3.5% each year. 
Ie. Year 1 value of 103.5 is equivalent to 100 at Year 0. 

Solution Needed<br />
1.  Portfolio Inflation Adjusted Values from Simulation <br />

| Portfolio Type | Median 20 th Year  | 10 % Best Case |  10 % Worst Case |
| ------------- | ------------- | ------------- | ------------- |
| A - Aggressive   |   |            |   | 
| I - Very Conservative  |  |         |   |

Description<br />
10% Best Case   :  90 th Percentile value among the 10,000 simulations<br />
10% Worst Case  :  10 th Percentile value among the 10,000 simulations

Hint<br />
To test your results create an account with Personal Capital, add a manual portfolio and go to Investment Checkup and compare your results.
