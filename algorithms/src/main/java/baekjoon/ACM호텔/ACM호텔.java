package baekjoon.ACM호텔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int f = N%H;
			if(f==0) {
				f = H;
			}
			sb.append(f);
			
			int r = ((N-1)/H)+1;
			if(r<10) {
				sb.append(0).append(r);
			} else {
				sb.append(r);
			}
			
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
		
	}
	
}
