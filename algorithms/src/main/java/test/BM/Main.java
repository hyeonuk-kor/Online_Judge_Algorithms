package test.BM;
import java.util.*;
public class Main {
	static int[][] answer;
	static int[][] dir = {{-1, 0}, {0, -1}};
	static int[][] solution(int n, boolean horizontal) {
		answer = new int[n][n];
		for(int i=1; i<=n; i++) {
			answer[i-1][i-1] = i*i-i+1;
			horizontal = !horizontal;
			if(horizontal) {
				fill(i-1, i-1, 1, 1, answer[i-1][i-1]);
				fill(i-1, i-1, 0, -1, answer[i-1][i-1]);
			} else {
				fill(i-1, i-1, 1, -1, answer[i-1][i-1]);
				fill(i-1, i-1, 0, 1, answer[i-1][i-1]);
			}
		}
		return answer;
	}
	static void fill(int y, int x, int d, int p, int n) {
		int ny = y + dir[d][0];
		int nx = x + dir[d][1];
		if(ny<0 || nx<0)
			return;
		if(p<0) {
			answer[ny][nx] = n-1;
			fill(ny, nx, d, p, n-1);
		} else {
			answer[ny][nx] = n+1;
			fill(ny, nx, d, p, n+1);
		}
	}
	public static void main(String[] args) {
		int answer[][] = solution(5, true);
		for(int i=0; i<answer.length; i++)
			System.out.println(Arrays.toString(answer[i]));
	}
}
