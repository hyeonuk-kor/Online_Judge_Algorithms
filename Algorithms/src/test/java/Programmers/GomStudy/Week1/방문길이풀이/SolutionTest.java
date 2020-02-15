package Programmers.GomStudy.Week1.방문길이풀이;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	
	@Test
	public void solution() {
		Assert.assertEquals(7, new Solution().Solution("ULURRDLLU"));
		Assert.assertEquals(7, new Solution().Solution("LULLLLLLU"));
	}
	
}
