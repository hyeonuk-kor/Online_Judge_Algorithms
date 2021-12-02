package baekjoon.에라토스테네스의체;
import java.io.*;
import java.util.*;
public class Main {
	static class P2960 {
		BufferedReader br;
		StringTokenizer st;
		int N, K, answer;
		P2960() {
			input();
			eratos();
			System.out.println(answer);
		}
		void eratos() {
			boolean prime[] = new boolean[N+1];
			int count = 0;
			for(int i=2; i<=N; i++) {
				prime[i] = true;
			}
			for(int i=2; i<=N; i++) { 
				if(prime[i]) {
					for(int j=i; j<=N; j+=i) {
						if(prime[j]) {
							prime[j] = false;
							count++;
						}
						if(count==K) {
							answer = j;
							return;
						}
					}
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2960();
	}
}