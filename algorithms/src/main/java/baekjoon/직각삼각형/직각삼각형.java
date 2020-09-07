package baekjoon.직각삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직각삼각형 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		do {
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			
			if(a==0 && b==0 && c==0)
				break;
			
			if(Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2) || Math.pow(b, 2)+Math.pow(c, 2)==Math.pow(a, 2) || Math.pow(a, 2)+Math.pow(c, 2)==Math.pow(b, 2)) {
				sb.append("right");
			} else {
				sb.append("wrong");
			}
			sb.append('\n');
			st = new StringTokenizer(br.readLine());
		} while(true);
		
		System.out.println(sb);
	}
	
}
