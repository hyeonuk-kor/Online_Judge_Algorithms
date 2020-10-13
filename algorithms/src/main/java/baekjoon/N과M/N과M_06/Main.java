package baekjoon.N과M.N과M_06;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, number[];
	static ArrayList<Integer> array;
	static LinkedHashSet<ArrayList<Integer>> set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new ArrayList<>();
		set = new LinkedHashSet<ArrayList<Integer>>();
		
		number = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		
		getNumber(0, 0);
		
		for(ArrayList<Integer> arr: set) {
			for(int i=0; i<arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write('\n');
		}
		bw.close();
	}

	static void getNumber(int idx, int index) {
		if(index==M) {
			set.add(new ArrayList<>(array));
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(array.contains(number[i])) continue;
			array.add(index, number[i]);
			getNumber(i+1, index+1);
			array.remove(index);
		}
	}
}

