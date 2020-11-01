70. Climbing Stais

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

3 possible approaches to solve this problem.
(1) Brute Force with recursion
(2) Recursion with Memoization
(3) Dynamic Programming 
(4) Fibonacci Sequence   Dynamic Programming with constant space use 
it's important to undersand how to solve this stair problem using Brute Froce with recursion, you will be able to derive the other 3 solutions from Brute Force approach.

Let’s look at some examples now and see if we can find a PATTERN.
Example 1: 1 Step stair case
Example 2: 2 Step
Example 3: 3 Step
Example 4: 4 Step

In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step. At every step we are calling the function climbStairs for step 1 and 2, and return the sum of returned values of both functions.

Clilmb Combination of N = 5:

			     ROOT                           
			      /\
		    1      	 	2
		   /\			/\
		1	2		1  2
		/\      /\     	     /\     /\
	     1	 2	1 2	    1 2     1 2
           /		  /\	
         1 	         1  2
	 /
	1 

count -> climbCombination(n-1) + climbCombination(n-2); // decremental opeartion
count -> climbCombination(i+1,n) + climbCombination(i+2,n); // incremental opeartion


new int[n+1];
O(N)
dp[0] = 0;
dp[1] = 1 // [1]
dp[2] = 2 // [1,1][2]
3 // [1,1,1],[1,2],[2,1] 
5 // [1,1,1,1][2,2][1,1,2][2,1,1][1,2,1]
for(int i=3; i< dp.length;i++)
{
	dp[i] = dp[i-1] + dp[i-2];
}

return dp[n];
