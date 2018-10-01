package com.dp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dp.lcs.EditDistance;
import com.dp.lcs.LongestIncreasingSequence;
import com.dp.lcs.MinimumStepsToOne;
import com.dp.lcs.SubSetSum;

public class MinimumStepsToOneTest {

	@Test
	public void testMinimumStepToOne() {
		MinimumStepsToOne m = new MinimumStepsToOne();
		assertEquals(3, m.minimumStepA(10));
		assertEquals(2, m.minimumStepA(9));
		assertEquals(4, m.minimumStepA(11));
		assertEquals(3, m.minimumStepA(12));

	}

	@Test
	public void longestIncreasingSequence() {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		assertEquals(5, lis.lis(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 }));
	}

	@Test
	public void editDistance() {
		EditDistance ed = new EditDistance();

		String str1 = "sunday";
		String str2 = "saturday";
		assertEquals(3, ed.editDistanceDp(str1, str2, str1.length(), str2.length()));
	}

	@Test
	public void subSetSum() {
		SubSetSum s = new SubSetSum();
		assertTrue(s.isSubSetSumDP(new int[] { 3, 34, 4, 12, 5, 2 }, 6, 9));
	}

}
