package com.dp.lcs;

public class KnapSack {

	public int knapSack(int w, int[] weights, int[] values, int n) {

		if (n == 0 || w == 0) {
			return 0;
		} else if (w > weights[n - 1]) {
			return knapSack(w, weights, values, n - 1);
		} else {
			return max(values[n - 1] + knapSack(w - weights[n - 1], weights, values, n - 1),
					knapSack(w, weights, values, n - 1));
		}
	}

	public int knapSackDp(int w, int[] weights, int[] values, int n) {

		int[][] dp = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < w; j++) {
				if (i == 0 || w == 0) {
					dp[i][j] = 0;
				} else if (weights[j] > w) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = max(values[j] + dp[i][j-weights[i-1]], dp[i-1][j]);
				}
			}
		}

		return 1;
	}

	private int max(int i, int knapSack) {
		return i > knapSack ? i : knapSack;
	}
}
