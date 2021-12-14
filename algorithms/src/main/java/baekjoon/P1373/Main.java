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
			StringBuilder sb = new StringBuilder();
			int calc = binaryNumber.length()%3;
			if(calc==0)
				calc = 3;
			for(int i=calc; i<3; i++) {
				binaryNumber = "0".concat(binaryNumber);
			}
			for(int i=0; i<binaryNumber.length(); i+=3) {
				String t = binaryNumber.substring(i, i+3);
				sb.append(Integer.parseInt(t, 2));
			}
			System.out.println(sb);
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