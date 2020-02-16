package programmers.gomStudy.week1Test.방문길이;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.방문길이.Solution;



public class SolutionTest {
	@Test
	public void solution() {
		Assert.assertEquals(7, new Solution().solution("ULURRDLLU"));
		Assert.assertEquals(7, new Solution().solution("LULLLLLLU"));
	}
}
