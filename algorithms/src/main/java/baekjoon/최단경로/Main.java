package baekjoon.최단경로;
import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int v, e;
	static int[] dist;
	static boolean[] visited;
	static List<List<Node>> list;

	static class Node {
		int index, distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		dist = new int[v+1];
		list = new ArrayList<List<Node>>();

		int start = Integer.parseInt(br.readLine());

		list.add(new ArrayList<Node>());

		Arrays.fill(dist, INF);
		for(int i=1; i<=v; i++) {
			list.add(new ArrayList<Node>());
		}

		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(v1).add(new Node(v2, cost));
		}

		dijkstra(start);

		for(int i=1; i<=v; i++) {
			if(dist[i]==INF)
				sb.append("INF").append('\n');
			else
				sb.append(dist[i]).append('\n');
		}

		System.out.println(sb.toString());
	}

	static void dijkstra(int start) {
		visited = new boolean[v+1];
		dist[start] = 0;
		//visited[start] = true;
		
		/*
		for(int i=0; i<list.get(start).size(); i++) {
			dist[list.get(start).get(i).index] = Math.min(dist[list.get(start).get(i).index], list.get(start).get(i).distance); 
		} */
		
		for(int i=1; i<=v-1; i++) {
			int now = findMinIndex();
			if(now<1) break;
			visited[now] = true;
			for(Node node : list.get(now)) {
				if(dist[node.index]>dist[now]+node.distance) {
					dist[node.index] = dist[now] + node.distance;
				}
			}
		}

	}

	private static int findMinIndex() {
		int min = INF;
		int index = -1;
		for(int i=1; i<=v; i++) {
			if(visited[i]) continue;
			if(dist[i] < min) {
				min = dist[i];
				index = i;
			}
		}
		return index;
	}

}
