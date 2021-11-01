package baekjoon.우수마을;
import java.io.*;
import java.util.*;
public class Main {
	static class P1949 {
		BufferedReader br;
		StringTokenizer st;
		List<List<Integer>> graph;
		int N, city[], dp[][];
		P1949() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			solve();
		}
		void solve() {
			int root = 1;
			dfs(root, -1); // tree 탐색 시작
			System.out.println(Math.max(dp[root][0], dp[root][1]));
		}
		void dfs(int x, int prev) { // x: 현재 정점 번호, prev : 부모 노드 번호
			dp[x][0] = 0;			
			dp[x][1] = city[x];		
			for(int y: graph.get(x)) {	
				if(y!=prev) {	// 부모노드를 제외한 나머지 노드를 탐색함
					dfs(y, x);	// dfs가 수행되면 아래의 dp[y][1], dp[y][0]이 계산될 것임
					dp[x][0] += Math.max(dp[y][1], dp[y][0]); // 인접한 마을 중 주민 수가 많은 곳 선택
					dp[x][1] += dp[y][0]; 
                }
			}
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				city = new int[N+1];
				dp = new int[N+1][2];	
				graph = new ArrayList<>();
				st = new StringTokenizer(br.readLine().trim());
				graph.add(new ArrayList<>());	
				for(int i=1; i<=N; i++) {
					city[i] = Integer.parseInt(st.nextToken());	// i번 도시의 주민 수
					graph.add(new ArrayList<>());
				}
				for(int i=1; i<N; i++) { // N-1개 줄에 걸쳐 인접한 마을 연결하기
					st = new StringTokenizer(br.readLine().trim());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					graph.get(y).add(x);
					graph.get(x).add(y);
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