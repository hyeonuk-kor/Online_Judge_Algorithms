package swexperts.수영장;
import java.io.*;
import java.util.*;
public class Solution {
	static int T, D, M, Q, Y, answer; // 테케, 일일권, 한달권, 3개월권, 1년권 요금, 정답
	static int month_plan[] = new int[13];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			D = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			answer = Y; // 1년치 요금이 최대일 것이다.
			for(int m=1; m<=12; m++) {
				month_plan[m] = Integer.parseInt(st.nextToken());
			}
			dfs(1, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void dfs(int month, int sum) {
		if(month>12) {
			answer = Math.min(answer, sum);
			return;
		} else {
			dfs(month+1, sum+M);
			dfs(month+3, sum+Q);
			dfs(month+1, sum+(D*month_plan[month]));
		}
	}
}