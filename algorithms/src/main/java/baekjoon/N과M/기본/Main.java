package baekjoon.N과M.기본;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, number[];
	static boolean[] check;
	static ArrayList<Integer> array;
	static LinkedHashSet<ArrayList<Integer>> set;
	
	public static void main(String[] args) throws Exception{
		input();
		getNumber();
		print();
		
	}

	private static void print() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(ArrayList<Integer> arr: set) {
			for(int i=0; i<arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write('\n');
		}
		bw.close();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
	}

	static void getNumber() {
		
	/* 종료 조건 설정
		if(~~)
		for(N중 for 문을 위한 반복문) {
			array.add(값추가); or array.add(인덱스, 값추가);
			getNumber(); 각 인덱스 별 함수 호출
			array.remove(인덱스를 통한 제거);
		}
	*/
	}
}