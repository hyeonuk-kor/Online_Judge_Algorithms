package programmers.gomStudy.week1Test.영어끝말잇기;

import org.junit.Assert;
import org.junit.Test;

import programmers.gomStudy.week1.영어끝말잇기.Solution;


public class SolutionTest {
	
	@Test
	public void solution() {

		Assert.assertArrayEquals(new int[] {3, 3}, new Solution().solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
		Assert.assertArrayEquals(new int[] {0, 0}, new Solution().solution(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
		Assert.assertArrayEquals(new int[] {1, 3}, new Solution().solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"}));
		
	}
	
}