package programmers.gomStudy.week1Test.스킬트리;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.스킬트리.Solution;



public class SolutionTest {
	
	@Test
	public void solution() {
		
		Assert.assertEquals(2, new Solution().solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
		
	}

}
