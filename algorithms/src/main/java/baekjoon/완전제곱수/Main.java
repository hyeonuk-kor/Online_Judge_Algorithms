package baekjoon.완전제곱수;
import java.io.*;
public class Main {
	static class P1977 {
		BufferedReader br;
		int N, M;
		P1977() {
			input();
			int sum = 0;
			int min = 0;
			for(int i=M; i>=N; i--) {
				double n = Math.sqrt(i);
				if((int)n*n==i) {
					sum = sum + i;
					min = i;
				}
			}
			if(sum==0) {
				System.out.println(-1);
				return;
			}
			System.out.println(sum);
			System.out.println(min);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				M = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1977();
	}
}
