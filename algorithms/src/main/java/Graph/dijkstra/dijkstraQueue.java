package Graph.dijkstra;
import java.util.*;
public class dijkstraQueue {
	static final int INF = (int)1e9;
	static int n, dist[], parent[];
	static boolean[] visit;
	public static void main(String[] args) {
		n = 7;
		int[][] graph = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 5, 3, 8, INF, INF, INF},
				{0,INF, 0, INF, 2, 4, INF, INF},
				{0,INF, INF, 0, 6, INF, INF, INF},
				{0,INF, INF, INF, 0, 3, 9, 10},
				{0,INF, INF, INF, INF, 0, INF, 6},
				{0,INF, INF, INF, INF, INF, 0, 7},
				{0,INF, INF, INF, INF, INF, INF, 0}
		};
		int start = 1; //출발 정점
		int end = 7; //도착 정점
		dijkstra(graph, start, end);
		for(int i=1; i<dist.length; i++) 
			System.out.println("dist[" + i + "]=" + dist[i]);
	}
	
	static String tracking(int end) {
		String str = end+" ";
		while(parent[end]!=-1) {
			str += parent[end] +" ";
			end = parent[end];
		}
		return new StringBuilder(str).reverse().toString();
	}
	
	static void dijkstra(int[][] graph, int start, int end) {
		visit = new boolean[n+1];
		dist = new int[n+1];
		parent = new int[n+1]; //경로 추적
		for(int i=0; i<=n; i++) {
			dist[i] = INF;
			parent[i] = -1;
		}
		dist[start] = 0;
		Queue<Integer> q = new LinkedList<>(); //하나씩 순서대로 검사하기 위한 큐 선언
		q.add(start);
		while(!q.isEmpty()) {
			int curV = q.poll();
			visit[curV] = true;
			for(int i=1; i<=n; i++) {
				if(visit[i]) continue;
				if(graph[curV][i]!=0) {
					if(dist[i] > dist[curV] + graph[curV][i]) {
						dist[i] = dist[curV] + graph[curV][i];
						parent[i] = curV;
						q.add(i);
					}
				}
			}
		}
		System.out.println(tracking(end));
	}
	
}
