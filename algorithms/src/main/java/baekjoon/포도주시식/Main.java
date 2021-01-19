package baekjoon.포도주시식;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int wine[] = new int[n+2];
		int memo[] = new int[n+2];
		for(int i=1; i<=n; i++)
			wine[i] = Integer.parseInt(br.readLine());
		for(int i=1; i<=2; i++) 
			memo[i] = memo[i-1] + wine[i];
		for(int i=3; i<=n; i++) {
			memo[i] = Math.max(memo[i-3]+wine[i-1], memo[i-2]) + wine[i]; //현재 와인 마시는 경우
			memo[i] = Math.max(memo[i], memo[i-1]); //현재 와인 안마시는 경우
		}
		System.out.println(memo[n]);
	}
}