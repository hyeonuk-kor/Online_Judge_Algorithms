package baekjoon.연속합;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] memo = new int[n];
		memo[0] = Integer.parseInt(st.nextToken());
		int max = memo[0];
		for(int i=1; i<n; i++) {
			int number = Integer.parseInt(st.nextToken());
			memo[i] = Math.max(memo[i-1]+number, number);
			max = Math.max(max, memo[i]);
		}
		System.out.println(max);
	}	
}