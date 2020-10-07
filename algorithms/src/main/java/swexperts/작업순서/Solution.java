package swexperts.작업순서;

import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			//graph & inDegree init
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			int[] inDegree = new int[V+1];
			
			// input
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i < E; i++ ) {
				int Va = Integer.parseInt(st.nextToken());
				int Vb = Integer.parseInt(st.nextToken());
				graph.get(Va).add(Vb); // 정점 Va에서 Vb로 이동
				inDegree[Vb]++; // 진입차수 증가
			}
			
			//topology_sort
			ArrayList<Integer> result = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=1; i<=V; i++) {
				if(inDegree[i]==0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				int currentNumber = q.poll();
				result.add(currentNumber);
				int getNodeSize = graph.get(currentNumber).size();
				for (int i = 0; i < getNodeSize; i++) {
					int nextNumber = graph.get(currentNumber).get(i);
					inDegree[nextNumber]--;
					if(inDegree[nextNumber]==0) {
						q.add(nextNumber);
					}
				}
			}
			
			String answer = "";
			for (Integer i : result) {
				answer += (i+" ");
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		} //end test_case
	
	} // end main
	
} // end class