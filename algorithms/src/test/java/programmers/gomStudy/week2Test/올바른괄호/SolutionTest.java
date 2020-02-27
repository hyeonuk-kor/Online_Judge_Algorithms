package programmers.gomStudy.week2Test.올바른괄호;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week2.올바른괄호.*;
public class SolutionTest {
	
	@Test
	public void solution() {
		Assert.assertTrue(new Solution().solution("()()"));
		Assert.assertTrue(new Solution().solution("(())()"));
		Assert.assertFalse(new Solution().solution(")()("));
		Assert.assertFalse(new Solution().solution("(()("));
	}

}
