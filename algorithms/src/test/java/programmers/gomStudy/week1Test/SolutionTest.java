package programmers.gomStudy.week1Test;


import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.solution방문길이.Solution;




public class SolutionTest {
	@Test
	public void solution() {
		Assert.assertEquals(8, new Solution().solution("ULURRDLLU"));
		Assert.assertEquals(7, new Solution().solution("URRLLLLLL"));
	}
}
