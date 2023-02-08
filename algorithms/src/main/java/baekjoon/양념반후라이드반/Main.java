package baekjoon.양념반후라이드반;
import java.io.*;
import java.util.*;
public class Main {
	static int A, B, C, X, Y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int answer = A*X + B*Y;
		int count = X+Y;
		for(int i=1; i<=count; i++) {
			int calc = 2*i*C + Math.max(0, X-i)*A + Math.max(0, Y-i)*B;
			answer = Math.min(answer, calc);
		}
		System.out.println(answer);
	}
}