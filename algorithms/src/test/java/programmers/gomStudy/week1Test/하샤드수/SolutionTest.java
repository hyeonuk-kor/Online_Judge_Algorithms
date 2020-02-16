package programmers.gomStudy.week1Test.하샤드수;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.하샤드수.Solution;

public class SolutionTest {


	@Test
	public void solution() {
		Assert.assertEquals(true, new Solution().solution(10));
		Assert.assertEquals(true, new Solution().solution(12));
		Assert.assertEquals(false, new Solution().solution(11));
		Assert.assertEquals(false, new Solution().solution(13));
	}


}
