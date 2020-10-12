package baekjoon.N과M1;

import java.util.*;
import java.io.*;

public class N과M1 {
	
	static int N, M;
	static ArrayList<Integer> permArr;
	static LinkedHashSet<ArrayList<Integer>> set;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		permArr = new ArrayList<>();
		set = new LinkedHashSet<ArrayList<Integer>>();
		perm(0);
		
		for(ArrayList<Integer> arrays: set) {
			for(int i=0; i<arrays.size(); i++) {
				bw.write(arrays.get(i)+" ");
			}
			bw.write('\n');
		}
		bw.close();
		
	}
	private static void perm(int cnt) {
		if(cnt==M) {
			set.add(new ArrayList<>(permArr));
		}
		
		for(Integer i=1; i<=N; i++) {
			if(permArr.contains(i)) continue;
			permArr.add(i);
			perm(cnt+1);
			permArr.remove(cnt);
		}
		
	}
}
