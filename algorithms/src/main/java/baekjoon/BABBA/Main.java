package baekjoon.BABBA;
import java.io.*;
public class Main {
	static class P9625 {
		BufferedReader br;
		int K, dp_a[], dp_b[]; // dp_a[K], dp_a[K] 버튼을 K번 눌렀을 때, 각각 a, b 갯수		
		P9625() {
			input();
			dp_a[0] = 1; // 초기 상태
			dp_b[1] = 1; // 초기 상태
			for(int i=2; i<=K; i++) {
				dp_a[i] = dp_a[i-1] + dp_a[i-2];
				dp_b[i] = dp_a[i-1] + dp_b[i-1];
			}
			System.out.println(dp_a[K]+" "+dp_b[K]);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				K = Integer.parseInt(br.readLine());
				dp_a = new int[K+1];
				dp_b = new int[K+1];
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P9625();
	}
}