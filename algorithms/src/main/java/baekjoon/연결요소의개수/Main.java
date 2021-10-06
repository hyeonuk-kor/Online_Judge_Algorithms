package baekjoon.연결요소의개수;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static boolean visit[];
	static List<ArrayList<Integer>> graph; // 인접 리스트
	public static void main(String[] args) {
		input();
		pro();
	}
	private static void pro() {
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	private static void dfs(int x) {
		visit[x] = true;
		for(int y: graph.get(x)) {
			if(!visit[y]) {
				dfs(y);
			}
		}
	}
	private static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 정점 수
			M = Integer.parseInt(st.nextToken()); // 간선 수
			visit = new boolean[N+1];
			graph = new ArrayList<>(); // 간선의 수만큼 확보
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for(int i=1; i<=M; i++) { // 간선 수 만큼 반복
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				graph.get(y).add(x);
				graph.get(x).add(y);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
