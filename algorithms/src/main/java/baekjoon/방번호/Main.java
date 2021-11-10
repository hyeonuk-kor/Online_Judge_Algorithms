package baekjoon.방번호;
import java.io.*;
public class Main {
	static class P1475 {
		BufferedReader br;
		int[] number;
		String input;
		P1475() {
			input();
			solve();
		}
		void solve() {
			int max = 0, index = 0;
			number = new int[10];
			for(char c: input.toCharArray()) {
				if(c=='6' || c=='9') {
					index = number[6]<number[9]?6:9;
				} else {
					index = c - '0';
				}
				max = Math.max(++number[index], max);
			}
			System.out.println(max);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1475();
	}
}
