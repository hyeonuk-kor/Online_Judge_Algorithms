package baekjoon.구간합구하기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, K;
	static long number[], prefix[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		number = new long[N];
		prefix = new long[N+1];
		for(int i=0; i<N; i++) {
			number[i] = Long.parseLong(br.readLine());
			prefix[i+1] += number[i] + prefix[i]; 
		}
		for(int i=N+2; i<=N+M+K+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				long temp = c-number[b-1];
				for(int j=b; j<N+1; j++)
					prefix[j] += temp;
				number[b-1] = c;
			} else {
				pw.println(prefix[(int)c]-prefix[b-1]);
			}
		}
		pw.flush();
	}
}