package baekjoon.계단오르기;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int stairs[] = new int[301];
		int memo[] = new int[301];
		for(int i=1; i<=N; i++) 
			stairs[i] = Integer.parseInt(br.readLine());
		memo[1] = stairs[1]; 
		memo[2] = stairs[1] + stairs[2];
		for(int i=3; i<=N; i++)
			memo[i] = Math.max(memo[i-2], memo[i-3]+stairs[i-1]) + stairs[i];
		System.out.println(memo[N]);
	}
}