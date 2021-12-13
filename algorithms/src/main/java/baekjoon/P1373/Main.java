package baekjoon.P1373;
import java.io.*;
public class Main {
	static class P1373 {
		BufferedReader br;
		String binaryNumber;
		P1373() {
			input();
			solve();
		}
		void solve() {
			System.out.println(Integer.parseInt(binaryNumber, 2));
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				binaryNumber = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1373();
	}
}