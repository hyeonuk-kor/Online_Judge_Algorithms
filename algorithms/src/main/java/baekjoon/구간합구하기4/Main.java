package baekjoon.구간합구하기4;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int number[] = new int[N+1];
		int prefixSum[] = new int[N+1];
		st = new StringTokenizer(br.readLine().trim());
		for(int i=1; i<=N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i-1]+number[i];
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			bw.append(Integer.toString(prefixSum[end]-prefixSum[start-1])+"\n");
		}
		bw.flush();
	}
}