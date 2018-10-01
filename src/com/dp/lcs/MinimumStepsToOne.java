package com.dp.lcs;

import java.util.Arrays;

public class MinimumStepsToOne {

	public static void main(String[] args) {
		MinimumStepsToOne m = new MinimumStepsToOne();
		m.fillArray(11);
		System.out.println(m.minimumStep(11));
	}

	int[] dp;

	public void fillArray(int n) {
		dp = new int[n+1];
		Arrays.fill(dp, -1);
	}

	// Arrays.fill(dp, -1);
	public int minimumStepRecursion(int n) {
		if (n == 1) // base case
			return 0;

		if (dp[n] != -1) { // check to avoid recalculation
			return dp[n];
		}
		int r = 1 + minimumStepRecursion(n - 1); // get step for n-1
		if (n % 2 == 0) {
			r = min(r, 1 + minimumStepRecursion(n / 2)); // calculate no. of step for n%2
		}
		if (n % 3 == 0) {
			r = min(r, 1 + minimumStepRecursion(n / 3)); // calculate no. of step for n%3
		}
		dp[n] = r; // store value for futue use
		return r;
	}

	private int min(int r, int i) {
		return r > i ? i : r;
	}

	private int minimumStep(int n) {
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0) {
				dp[i] = min(dp[i], 1 + dp[i / 2]);
			}
			if (i % 3 == 0) {
				dp[i] = min(dp[i], 1 + dp[i / 3]);
			}
		}
		return dp[n];
	}
	
	public int minimumStepA(int n) {
		fillArray(n+1);
		return minimumStep(n);
	}

}
