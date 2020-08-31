package baekjoon.숫자의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의갯수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		char[] result = (A*B*C+"").toCharArray();
		
		for(char c='0'; c<='9'; c++) {
			int count = 0;
			for(char i : result) {
				if(i==c) count++;
			}
			sb.append(count).append('\n');
		}
		
		System.out.print(sb);
	}
	
}
