package baekjoon.트리와쿼리;
import java.io.*;
import java.util.*;
public class Main {
	static class P15681 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		List<List<Integer>> tree;
		int N, R, Q, dp[];
		P15681() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			System.out.println(sb);
		}
		void input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				Q = Integer.parseInt(st.nextToken());
				dp = new int[N+1];
				tree = new ArrayList<>();
				for(int i=0; i<=N; i++)
					tree.add(new ArrayList<>());
				for(int i=1; i<=N-1; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					tree.get(y).add(x);
					tree.get(x).add(y);
				}
				dfs(R, -1);
				sb = new StringBuilder();
				for(int q=1; q<=Q; q++) {
					int u = Integer.parseInt(br.readLine());
					sb.append(dp[u]).append('\n');
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void dfs(int x, int prev) {
			dp[x] = 1;
			for(int y: tree.get(x)) {
				if(y!=prev) {
					dfs(y, x);
					dp[x] += dp[y];
				}
			}
		}
	}
	public static void main(String[] args) {
		new P15681();
	}
}
