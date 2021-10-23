package baekjoon.공넣기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, bucket[] = new int[101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int m=1; m<=M; m++) {
			st = new StringTokenizer(br.readLine().trim());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			while(i<=j)
				bucket[i++]=k;
		}
		for(int i=1; i<=N; i++)
			sb.append(bucket[i]).append(" ");
		System.out.println(sb);
	}
}