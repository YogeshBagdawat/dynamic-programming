package com.dp.lcs;

public class SubSetSum {

	public boolean isSubSetSum(int[] set, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (n == 0 & sum != 0) {
			return false;
		} else {
			return isSubSetSum(set, n - 1, sum) || isSubSetSum(set, n - 1, sum - set[n - 1]);
		}
	}

	public boolean isSubSetSumDP(int[] set, int n, int sum) {

		boolean[][] dp = new boolean[sum + 1][n + 1];
		for (int i = 1; i <= sum; i++) {
			dp[i][0] = false;
		}
		for (int i = 0; i <= n; i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j-1];
				if(i>=set[j-1]) {
					dp[i][j] = dp[i][j] || dp[i-set[j-1]][j-1];
				}
			}
		}

		return dp[sum][n];
	}
}
