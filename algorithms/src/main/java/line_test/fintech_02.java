package line_test;
import java.util.*;
public class fintech_02 {
	static class Solution {
		Solution() {
			int[][] array = {
					{0, 1, 2, 5, 3, 7},
					{1, 2, 3, 2, 1},
					{1, 2, 3, 2, 1, 4, 3, 2, 2, 1},
					{1, 2, 1, 2, 1}
			};
			for(int[] arr: array)
				System.out.println(solution(arr));
		}
		public int solution(int[] arr) {
			int answer=0;
			// 초기 모든 길이 1로 두고 계산
			Integer[] dp1 = new Integer[arr.length];
			Integer[] dp2 = new Integer[arr.length];
			return answer;
		}
	}
	public static void main(String[] args) {
		new Solution();
	}
}
