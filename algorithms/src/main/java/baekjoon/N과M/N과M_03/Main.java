package baekjoon.N과M.N과M_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
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
		
		getNumber(0);
		
		for(ArrayList<Integer> arr: set) {
			for(int i=0; i<arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write('\n');
		}
		bw.close();
	}

	static void getNumber(int index) {
		if(index==M) {
			set.add(new ArrayList<>(array));
			return;
		}
		
		for(int i=1; i<=N; i++) {
			array.add(i);
			getNumber(index+1);
			array.remove(index);
		}
	}
}
