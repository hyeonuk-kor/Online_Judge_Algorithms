package baekjoon.N과M4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N과M4 {
	
	static int N, M;
	static ArrayList<Integer> seqArr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seqArr = new ArrayList<>();
		sb = new StringBuilder();
		
		getSeq(1);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}
	
	private static void getSeq(Integer number) {
		if(seqArr.size()==M) {
			for (Integer integer : seqArr) {
				sb.append(integer).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(Integer i=number; i<=N; i++) {
			seqArr.add(i);
			getSeq(i);
			seqArr.remove(seqArr.size()-1);
		}
	}
	
}
