package baekjoon.트리의독립집합;
import java.io.*;
import java.util.*;
public class Main {
	static class P2213 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		List<List<Integer>> tree;
		List<Integer> num;
		int N, W[], dp[][]; // dp[i][0] : 현재 정점을 선택하지 않고, 가능한 최대 크기, dp[i][1] : 현재 정점을 선택하고 가능한 최대크기
		P2213() {
			input();
			solve();
			System.out.println(sb);
		}
		void solve() {
			int root = 1;
			dfs(root, root); // 완료
			num = new ArrayList<>();
			sb = new StringBuilder();
			if(dp[root][0]>dp[root][1]) { //
				sb.append(dp[root][0]).append('\n');
				trace(root, root, false);
			} else {
				sb.append(dp[root][1]).append('\n');
				trace(root, root, true);
			}
			Collections.sort(num);
			for(int n: num)
				sb.append(n).append(' ');
			sb.append('\n');
		}
		void trace(int x, int parent, boolean visit) { // visit : 선택유무
			if(visit)
				num.add(x);
			for(int y: tree.get(x)) {
				if(y==parent) continue;
				if(!visit && dp[y][1]>=dp[y][0]) {
					trace(y, x, true);
				} else {
					trace(y, x, false);
				}
			}
		}
		void dfs(int x, int parent) { // x : 현재 정점, parent : 부모
			dp[x][0] = 0;
			dp[x][1] = W[x];
			for(int y: tree.get(x)) {
				if(y!=parent) {
					dfs(y, x);
					dp[x][0] += Math.max(dp[y][1], dp[y][0]); // 선택을 안했기 때문에, 둘 다 할 수 있고 그 중에서 최대치를 취한다.
					dp[x][1] += dp[y][0]; // 현재 노드에서 선택을 했기 때문에, 자식은 선택 안한 것을 골라야함
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				W = new int[N+1];
				dp = new int[N+1][2];
				tree = new ArrayList<>();
				st = new StringTokenizer(br.readLine().trim());
				tree.add(new ArrayList<>());
				for(int n=1; n<=N; n++) {
					W[n] = Integer.parseInt(st.nextToken());
					tree.add(new ArrayList<>());
				}
				for(int n=1; n<N; n++) {
					st = new StringTokenizer(br.readLine().trim());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					tree.get(y).add(x);
					tree.get(x).add(y);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2213();
	}
}