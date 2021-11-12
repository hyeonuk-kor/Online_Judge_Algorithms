package baekjoon.거스름돈;
import java.io.*;
public class Main {
	static class P5585 {
		BufferedReader br;
		int N, coin[] = {500, 100, 50, 10, 5, 1};
		P5585() {
			input();
			int count = 0;
			for(int i=0; i<coin.length; i++) {
				if(N/coin[i]>0) {
					count += N/coin[i];
					N = N%coin[i];
				}
			}
			System.out.println(count);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				N = 1000 - N;
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P5585();
	}
}
