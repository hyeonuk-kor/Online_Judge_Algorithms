package baekjoon.N과M9;

import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, number[];
	static boolean[] check;
	static ArrayList<Integer> answer;
	static Set<ArrayList<Integer>> set;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		check = new boolean[N];
		answer = new ArrayList<>();
		set = new LinkedHashSet<ArrayList<Integer>>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < number.length; i++) {
			number[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		
		dfs(0);
		
		for(ArrayList<Integer> arr: set) {
			for (int i = 0; i < arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write('\n');
		}
		bw.close();
		
	}
	
	static void dfs(int cnt) {
		if(cnt==M) {
			set.add(new ArrayList<>(answer));
			return;
		}
		
		for (int i = 0; i < number.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			answer.add(number[i]);
			dfs(cnt+1);
			answer.remove(cnt);
			check[i] = false;
		}
	}
	
}
