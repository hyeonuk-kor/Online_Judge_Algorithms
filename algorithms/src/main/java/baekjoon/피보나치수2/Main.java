package baekjoon.피보나치수2;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long fibo[] = new long[91];
		fibo[0] = 0; fibo[1] = 1;
		int N = Integer.parseInt(br.readLine());
		for(int i=2; i<=N; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		System.out.println(fibo[N]);
	}
}
