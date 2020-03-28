package baekjoon.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] people = new int[101][101];
		int[] degree = new int[101];
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			people[parent][child] = people[child][parent] = 1;
		}
		
//		Queue<Integer> store = new LinkedList<Integer>(); // bfs
		Stack<Integer> store = new Stack<Integer>(); // dfs
		store.add(start);
		while(!store.isEmpty()) { //bfs or dfs
//			int currentPeole = store.poll();
			int currentPeole = store.pop();
			for(int next=1; next<=n; next++) {
				if(people[currentPeole][next]==0) //bfs 탐색하려는 부분이 0이라면
					continue;
				if(degree[next]!=0) // 이미 촌수가 계산되었다면
					continue;
				// 나머지는 계산한다.
				degree[next] = degree[currentPeole] + 1;
				store.add(next);
			}
		}
		
		System.out.println(degree[end]==0?-1:degree[end]);
		
	} // end of main

} // end of class
