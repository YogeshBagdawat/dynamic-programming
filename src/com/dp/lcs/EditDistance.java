package com.dp.lcs;

import java.util.Arrays;

public class EditDistance {

	// time complexity is O(3^n)
	public int editDistanceR(String str1, String str2, int m, int n) {
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		if (str1.charAt(m) == str2.charAt(n)) {
			return editDistanceR(str1, str2, m - 1, n - 1);
		} else {
			return 1 + min(editDistanceR(str1, str2, m - 1, n), editDistanceR(str1, str2, m, n - 1),
					editDistanceR(str1, str2, m - 1, n - 1));
		}
	}

	private int min(int editDistance, int editDistance2, int editDistance3) {
		return editDistance < editDistance2 && editDistance < editDistance3 ? editDistance
				: (editDistance2 < editDistance && editDistance2 < editDistance3 ? editDistance2 : editDistance3);
	}

	public int editDistanceDp(String str1, String str2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		// Arrays.fill(dp, 0);
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
}
