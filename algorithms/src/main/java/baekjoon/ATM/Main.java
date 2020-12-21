package baekjoon.ATM;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p[] = new int[N];
		for(int i=0; i<N; i++) 
			p[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(p);
		int sum = 0;
		for(int i=N; i>=1; i--) 
			sum += p[N-i]*i;
		System.out.println(sum);
	}
}
