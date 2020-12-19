package baekjoon.DFS와BFS;
import java.io.*;
import java.util.*;
public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, V;
	static boolean graph[][];
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];
		boolean visit[] = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		dfs(V, visit.clone());
		bfs(V, visit.clone());
		bw.flush();
	}
	static void bfs(int v, boolean[] visit) throws Exception {
		Queue<Integer> q = new ArrayDeque<Integer>();
		visit[v] = true;
		q.add(v);
		while(!q.isEmpty()) {
			v = q.poll();
			bw.append(v+" ");
			for(int i=1; i<=N; i++) {
				if(graph[v][i] && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		bw.append("\n");
	}
	static void dfs(int v, boolean[] visit) throws Exception {
		Stack<Integer> s = new Stack<Integer>();
		s.push(v);
		while(!s.isEmpty()) {
			v = s.peek();
			if(!visit[v]) bw.append(v+" ");
			visit[v] = true;
			boolean check = false;
			for(int i=1; i<=N; i++) {
				if(graph[v][i] && !visit[i]) {
					s.push(i);
					check = true;
					break;
				}
			}
			if(!check) s.pop();
		}
		bw.append("\n");
	}
}
