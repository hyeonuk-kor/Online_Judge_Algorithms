package baekjoon.FlymetotheAlphaCentauri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int half = 1;
			long start = 1;
			int calc = 1;
			for(calc=1; start<y-x; calc++) {
				start += half;
				if(calc%2!=0)
					half++;
			}
			System.out.println(calc);
		}
		
	}
	
}
