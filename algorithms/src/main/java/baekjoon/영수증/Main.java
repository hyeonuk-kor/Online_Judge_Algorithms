package baekjoon.영수증;
import java.io.*;
public class Main {
	static class P5565 {
		BufferedReader br;
		int answer =0;
		P5565() {
			input();
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = Integer.parseInt(br.readLine());
				for(int i=0; i<9; i++) {
					answer -= Integer.parseInt(br.readLine());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P5565();
	}
}