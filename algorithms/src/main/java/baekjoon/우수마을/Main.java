package baekjoon.우수마을;
import java.io.*;
import java.util.*;
public class Main {
	static class P1949 {
		BufferedReader br;
		StringTokenizer st;
		List<List<Integer>> tree;
		int N, city[], dp[][];
		P1949() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			solve();
		}
		void solve() {
			dfs(1, -1);
			System.out.println(Math.max(dp[1][0], dp[1][1]));
		}
		void dfs(int x, int prev) {
			dp[x][0] = 0;
			dp[x][1] = city[x];
			for(int y: tree.get(x)) {
				if(y!=prev) {
					dfs(y, x);
					dp[x][0] += Math.max(dp[y][0], dp[y][1]);
					dp[x][1] += dp[y][0];
				}
			}
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				city = new int[N+1];
				dp = new int[N+1][2];
				tree = new ArrayList<>();
				st = new StringTokenizer(br.readLine().trim());
				tree.add(new ArrayList<>());
				for(int i=1; i<=N; i++) {
					city[i] = Integer.parseInt(st.nextToken());
					tree.add(new ArrayList<>());
				}
				for(int i=1; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					tree.get(y).add(x);
					tree.get(x).add(y);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1949();
	}
}
