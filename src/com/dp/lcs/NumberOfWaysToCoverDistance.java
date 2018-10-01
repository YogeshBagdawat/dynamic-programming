package com.dp.lcs;

public class NumberOfWaysToCoverDistance {

	public int dist(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return dist(n - 1) + dist(n - 2) + dist(n - 3);
		}
	}

	public int distDp(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}
}
