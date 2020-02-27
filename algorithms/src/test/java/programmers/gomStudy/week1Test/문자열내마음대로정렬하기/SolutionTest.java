package programmers.gomStudy.week1Test.문자열내마음대로정렬하기;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.문자열내마음대로정렬하기.Solution;



public class SolutionTest {
	
	@Test
	public void solution() {
		Assert.assertArrayEquals(new String[] {"car", "bed", "sun"}, new Solution().solution(new String[] {"sun","bed","car"}, 1));
		Assert.assertArrayEquals(new String[] {"abcd", "abce", "cdx"}, new Solution().solution(new String[] {"abce","abcd","cdx"}, 2));

	}
}