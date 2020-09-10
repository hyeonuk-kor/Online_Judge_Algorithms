package baekjoon.수정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수정렬하기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[2000001];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			check[num+1000000]=true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < check.length; i++) {
			if(check[i])
				sb.append(i-1000000).append('\n');
		}
		System.out.println(sb);
	}

}
