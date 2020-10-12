package baekjoon.N과M10;

import java.util.*;
import java.io.*;

public class Main {

	static int N, M, number[];
	static boolean[] check;
	static ArrayList<Integer> answer;
	static Set<ArrayList<Integer>> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		
		answer = new ArrayList<Integer>();
		set = new LinkedHashSet<ArrayList<Integer>>();
		dfs(0, 0);

		for(ArrayList<Integer> arrays: set) {
			for(int i=0; i<arrays.size(); i++) {
				bw.write(arrays.get(i)+" ");
			}
			bw.write('\n');
		}
		bw.close();
		
	}
	
	static void dfs(int idx, int cnt) {
		if(cnt==M) {
			set.add(new ArrayList<>(answer));
			return;
		}
		
		for(int i=idx; i<N; i++) {
			answer.add(number[i]);
			dfs(i+1, cnt+1);
			answer.remove(cnt);
		}
		
	}
	
}
