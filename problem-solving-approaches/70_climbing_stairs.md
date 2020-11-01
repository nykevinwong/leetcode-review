70. Climbing Stais

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

3 possible approaches to solve this problem.
(1) Brute Force with recursion
(2) Recursion with Memoization
(3) Dynamic Programming 
(4) Fibonacci Sequence   Dynamic Programming with constant space use 

Clilmb Combination:

				 1
				 /\
		    1      	 	2
			/\			/\
		1		2		1  2
		/\      /\      /\  /\
	  1	 2		1 2	   1 2 	1 2
     /		  /\	
    1 		 1	2

count -> climbCombination(n-1)+climb(n-2); // for dp conversion
count -> climb(i+1,k) + climb(i+2,k);

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
