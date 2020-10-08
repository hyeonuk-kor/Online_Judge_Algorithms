package baekjoon.최소비용구하기;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	
	private int index;
	private int cost;
	
	public int getIndex() {
		return index;
	}
	
	public int getCost() {
		return cost;
	}

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}

public class Main {
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] d = new int[N+1];
		Arrays.fill(d, (int)1e9);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex();
			int cost = node.getCost();
			
			if(cost > d[now]) continue;
			for (int i = 0; i < graph.get(now).size(); i++) {
				int calc = d[now] + graph.get(now).get(i).getCost();
				if(calc < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = calc;
					pq.add(new Node(graph.get(now).get(i).getIndex(),calc));
				}
			}
		}
		
		System.out.println(d[end]);
		
	} // end main

} // end class
