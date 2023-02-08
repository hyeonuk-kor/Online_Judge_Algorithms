package baekjoon.카드구매하기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N+1];
		int[] dy = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dy[i] = Math.max(dy[i], dy[i-j]+P[j]);
			}
		}
		System.out.println(dy[N]);
	}
}
