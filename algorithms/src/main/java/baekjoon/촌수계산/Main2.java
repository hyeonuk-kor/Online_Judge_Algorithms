package baekjoon.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int man1 = Integer.parseInt(st.nextToken());
		int man2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] parent = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			parent[c] = p; // 부모 저장
		}
		
		// 사람번호, 촌수
		HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
		
//		man1의 조상으로 올라가면서 촌수를 기록
		int val = 0;
		while(man1!=0) {
			store.put(man1, val++);
			man1 = parent[man1];
		}
		
//		man2의 조상으로 올라가면서 man1과 공통조상이 있는지 검사
		val = 0;
		while(man2!=0) {
			if(store.containsKey(man2)) { // 공통 조상이냐?
				System.out.println(store.get(man2) + val);
				return;
			}
			val++;
			man2 = parent[man2]; //부모값을 넣기
		}
		System.out.println(-1); // 공통조상을 몾찾음
		
	} // end of main

} // end of class
