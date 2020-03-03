package swexperts.최장경로;

import java.util.Scanner;

public class 최장경로2 {
	
	static int N;
	static int M;
	static int[][] adj;
	static int[][] memo; //어떤 방문체크상태로 어떤 정점에 도달했는지
	//그래프 표현 방법
	/*
	 * 1. 간선 배열
	 *  1 2
	 *  2 3
	 *  2 4
	 *  3 4
	 *  
	 * 2. 인접 리스트 
	 *  1 2
	 *  2 1 3 4
	 *  3 2 4
	 *  
	 * 3. 인접 행렬
	 *    1 2 3 4
	 *  1 0 1 0 0
	 *  2 0 0 1 1
	 *  3 0 0 0 1
	 *  4 0 0 0 0
	 *  
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // 정점의 갯수 1<=N <=10
			M = sc.nextInt(); // 간선의 갯수 <= 20
			//간선갯수 공식 n(n-1)/2
			adj = new int[N+1][N+1];
			visited = new boolean[N+1];
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a][b] = 1;
				adj[b][a] = 1;
			}
			ans = 0;
			for(int i=1; i<=N; i++) {
				visited[i] = true;
				dfs(i,1);
				visited[i] = false;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static boolean[] visited;
	static int ans = 0;
	
	static void dfs(int v, int cnt) {
		//더이상 방문할 노드가 없음 : 기저 파트
		//cnt이 가장 큰 값
		ans = Math.max(ans, cnt);
		
		//모든 노드 중에서 나와 간선이 존재하고, 아직 방문하지 않은 노드라면 방문
		for(int i=1; i<=N; i++) {
			if(adj[v][i]==1 && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
}