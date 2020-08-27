package baekjoon.파티가끝나고난뒤;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(st.nextToken()); // 1m 당 사람의 수
		int P = Integer.parseInt(st.nextToken()); // 파티가 열렸던 곳의 넓이
		int sangeunNum = L*P;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<5; i++) { // 10^6 보다 작은 양의 정수 5개 입력
			sb.append((Integer.parseInt(st.nextToken()) - sangeunNum)+" ");
		}
		System.out.println(sb);
		
		
		
		
	}

}