package com.dp.lcs;

import java.util.Arrays;

public class LongestIncreasingSequence {

	public int lis(int[] a) {
		int len = a.length;
		int[] lis = new int[len];
		int[] lisR = new int[len];
		Arrays.fill(lisR, -1);
		lisR[0] = a[0];
		Arrays.fill(lis, 1);
		int max = 1;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					lis[i] = max(lis[i], lis[j] + 1);
				}
			}
			if (lis[i] > max) {
				max = lis[i];
				lisR[i] = a[i];
			}
		}
		for (int l : lisR) {
			if (l != -1) {
				System.out.println(l);
			}
		}

		return max;
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}
}
