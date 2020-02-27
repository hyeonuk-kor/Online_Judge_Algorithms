package programmers.gomStudy.week1Test.소수만들기;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.소수만들기.Solution;


public class SolutionTest {
	
	@Test
	public void solution() {
		Assert.assertEquals(1, new Solution().solution(new int[] {1,2,3,4}));
		Assert.assertEquals(4, new Solution().solution(new int[] {1,2,7,6,4}));
	}
	
}