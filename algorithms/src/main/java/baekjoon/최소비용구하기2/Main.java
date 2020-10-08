package baekjoon.최소비용구하기2;

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
		int[] parent = new int[N+1];
		Arrays.fill(d, (int)1e9);
		ArrayList<Integer> result = new ArrayList<>();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.add(new Node(start, 0));
		result.add(start);
		
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
					parent[graph.get(now).get(i).getIndex()] = now; 
				}
			}
		}
		
		Stack<Integer> stack = new Stack<>();
        int cur = end;
        int cityCnt=0;
        while(cur != start) {
            stack.push(cur);
            cityCnt++;
            cur = parent[cur];
        }
        stack.push(start);
        cityCnt++;
		
		System.out.println(d[end]);
		System.out.println(cityCnt);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	} // end main

} // end class
