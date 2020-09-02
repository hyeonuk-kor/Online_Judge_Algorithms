package baekjoon.문자열반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(char c: st.nextToken().toCharArray()) {
				for(int i=0; i<n; i++) {
					sb.append(c);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
}
