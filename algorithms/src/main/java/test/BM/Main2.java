package test.BM;
import java.util.*;
public class Main2 {
	static boolean number[];
	static int answer = 0;
	public static int solution(int[][] casted) {
		number = new boolean[13];
		answer = casted.length;
		dfs(0, casted);
		return answer;
	}
	static boolean check() {
		for(int i=1; i<=12; i++) {
			if(!number[i])
				return false;
		}
		return true;
	}
	static void dfs(int depth, int[][] casted) {
		number[0] = false;
		if(depth>answer) {
			return;
		} else {
			if(check()) {
				answer = Math.min(answer, depth);
				System.out.println(answer);
				return;
			} 
			for(int i=depth; i<casted.length; i++) {
				int sum = casted[i][0] + casted[i][1];
				for(int j=0; j<sum; j++) {
					if(number[j]) continue;
					number[j] = true;
					number[sum-j] = true;
					dfs(depth+1, casted);
					number[j] = false;
					number[sum-j] = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		int casted[][] = {{1, 1}, {5, 6}, {5, 1}, {5, 5}, {4, 1}, {6, 6}, {5, 6}, {5, 6}, {6, 5}, {3, 6}, {3, 4}};
		//int casted[][] = {{5, 6}, {4, 6}, {6, 6}, {6, 3}, {6, 2}, {2, 5}, {5, 5}, {6, 5}, {1, 6}, {2, 4}};
		System.out.println(solution(casted));
	}
}
