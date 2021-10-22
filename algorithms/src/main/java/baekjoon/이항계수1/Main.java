package baekjoon.이항계수1;
import java.io.*;
import java.util.*;
public class Main {
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(f(N, K));
	}
	static int f(int n, int k) {
		if(n==k || k==0)
			return 1;
		return f(n-1, k-1) + f(n-1, k);
	}
}