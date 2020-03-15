package programmers.gomStudy.week1Test.다음큰숫자;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import programmers.gomStudy.week1.다음큰숫자.Solution;



public class SolutionTest {
	@Test
	public void solution() {
		Assert.assertEquals(83, new Solution().solution(78));
	
	}
}
