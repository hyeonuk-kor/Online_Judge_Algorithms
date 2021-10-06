package baekjoon.소수의연속합;
import java.io.*;
public class Main {
	static int N, prime[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		int sum = 0, ans = 0;
		for(int L=1, R=1; L<=prime.length; L++) {
			// 왼쪽 값을 합에서 뺀다.
			sum -= prime[L-1];
			// R을 증가시키면서 sum보다 커질때까지 더해나간다.
			while(R+1 <= prime.length && sum<N) {
				sum += prime[R++];
			}
			// 정답을 갱신한다.
			if(sum==N)
				ans++;
		}
		System.out.println(ans);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			Eratos();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static void Eratos() {
		int count = 0;
		boolean check[] = new boolean[N+1];
		for(int i=2; i<=N; i++) {
			if(!check[i]) {
				count++;
				for(int j=i+i; j<=N; j=j+i) {
					check[j] = true;
				}
			}
		}
		prime = new int[count+1];
		int index = 1;
		for(int i=2; i<=N; i++) {
			if(!check[i])
				prime[index++] = i;
		}
	}
}
