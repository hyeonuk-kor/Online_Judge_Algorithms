package baekjoon.파도반수열;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long P[] = new long[101];
		P[1] = 1; P[2] =1; P[3]=1;
		for(int i=4; i<=100; i++) 
			P[i] = P[i-2] + P[i-3];
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(P[N]);
		}
	}
}
