package baekjoon.도시분할계획;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {

	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return distance;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
	
}

public class Main {
	
	public static int v,e;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int result = 0;
	
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=v; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(cost, a, b));
		}
		
		Collections.sort(edges);
		int last = 0;
		
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			if(findParent(a)!=findParent(b)) {
				unionParent(a, b);
				result += cost;
				last = cost;
			}
		}
		
		System.out.println(result - last);
	}

}
