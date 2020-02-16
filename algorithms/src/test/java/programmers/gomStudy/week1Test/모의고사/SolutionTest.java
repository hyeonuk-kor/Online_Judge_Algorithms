package programmers.gomStudy.week1Test.모의고사;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import programmers.gomStudy.week1.모의고사.Solution;


public class SolutionTest {
	@Test
	public void solution() {
		Assert.assertEquals(new int[] {1}, new Solution().solution(new int[] {1,2,3,4,5}));
		Assert.assertEquals(new int[] {1,2,3}, new Solution().solution(new int[] {1,3,2,4,2}));
	}
}
