package baekjoon.N과M3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N과M3 {

	static int N, M;
	static ArrayList<Integer> rePermArr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rePermArr = new ArrayList<>();
		sb = new StringBuilder();
		
		for(Integer i=1; i<=N; i++) {
			rePermArr.add(i);
			rePerm(i);
			rePermArr.remove(i);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	private static void rePerm(Integer num) {
		if(rePermArr.size()==M) {
			for (Integer integer : rePermArr) {
				sb.append(integer).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(Integer i=1; i<=N; i++) {
			rePermArr.add(i);
			rePerm(num);
			rePermArr.remove(rePermArr.size()-1);
		}
	}

}
