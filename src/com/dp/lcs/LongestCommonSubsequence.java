package com.dp.lcs;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		LongestCommonSubsequence lc = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;
		System.out.println(lc.lcsdp(X, Y, m, n));
	}

	public int lcs(char[] a, char[] b, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (a[m - 1] == b[n - 1]) {
			return 1 + lcs(a, b, m - 1, n - 1);
		} else {
			return max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1));
		}
	}

	private int max(int a, int b) {

		return a > b ? a : b;
	}

	public int lcsdp(char[] a, char[] b, int m, int n) {

		int[][] l = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					l[i][j] = 0;
				}
				else if (a[i - 1] == b[j - 1]) {
					l[i][j] = l[i - 1][j - 1] + 1;
				} else {
					l[i][j] = max(l[i - 1][j], l[i][j - 1]);
				}
			}
		}
		return l[m][n];
	}

}
