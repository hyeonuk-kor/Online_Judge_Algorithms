package baekjoon.N과M2;

import java.io.*;
import java.util.*;

public class N과M2 {

	static int N, M;
	static ArrayList<Integer> combArr;
	static LinkedHashSet<ArrayList<Integer>> set;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		combArr = new ArrayList<>();

	}

	private static void comb(int number) {
		for(Integer i=number+1; i<=N; i++) {
			if(combArr.contains(i))	continue;
			combArr.add(i);
			comb(i);
			combArr.remove(i);
		}
	}

}
