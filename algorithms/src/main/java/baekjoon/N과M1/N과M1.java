package baekjoon.N과M1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M1 {
	
	static int N, M;
	static List<Integer> permArr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		permArr = new ArrayList<>();
		for(Integer i=1; i<=N; i++) {
			permArr.add(i);
			perm(i);
			permArr.remove(i);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	private static void perm(int number) {
		if(permArr.size()==M) {
			for (Integer i : permArr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(Integer i=1; i<=N; i++) {
			if(permArr.contains(i))
				continue;
			permArr.add(i);
			perm(i);
			permArr.remove(i);
		}
	}
}
