package baekjoon.OX퀴즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[][] str = new char[N][];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine().toCharArray();
		}
		
		for (char[] cs : str) {
			int count = 1;
			int sum = 0;
			for (char i : cs) {
				if(i=='O') {
					sum+=count++;
				} else {
					count=1;
				}
			}
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
}
