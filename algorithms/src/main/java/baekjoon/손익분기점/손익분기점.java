package baekjoon.손익분기점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 손익분기점 {

	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(B>=C) {
			System.out.println(-1);
		} else {
			System.out.println(A/(C-B)+1);
		}
	}
}