package programmers.gomStudy.week1Test.K번째수;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.K번째수.Solution;


public class SolutionTest {
	
	@Test
	public void solution() {
		
		Assert.assertArrayEquals(new int[] {5,6,3}, new Solution().solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] { {2,5,3}, {4,4,1}, {1,7,3} }));
		
	}
	
}