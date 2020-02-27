package programmers.gomStudy.week3Test.네트워크;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week3.네트워크.Solution;

public class SolutionTest {

	@Test
	public void solution() {
	//	Assert.assertEquals(83, new Solution().solution(78));
		Assert.assertEquals(2, new Solution().solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
		Assert.assertEquals(2, new Solution().solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
	}	
	
}
