package baekjoon.N과M2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M2 {

	private static StringBuilder sb;
	private static int N, M;
	private static List<Integer> combArr;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		combArr = new ArrayList<>();
		
		for(Integer i=1; i<=N; i++) {
			combArr.add(i);
			comb(i);
			combArr.remove(i);
		}
		
		bw.write(sb.toString());
		bw.close();
	}

	private static void comb(int number) {
		if(combArr.size()==M) {
			for (Integer integer : combArr) {
				sb.append(integer).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(Integer i=number+1; i<=N; i++) {
			if(combArr.contains(i))
				continue;
			combArr.add(i);
			comb(i);
			combArr.remove(i);
		}
	}

}
