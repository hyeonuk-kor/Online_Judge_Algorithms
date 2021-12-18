package baekjoon.그릇;
import java.io.*;
public class Main {
	static class P7567 {
		BufferedReader br;
		String str;
		P7567() {
			input();
			pro();
		}
		void pro() {
			int sum = 10;
			for(int i=1; i<str.length(); i++) {
				if(str.charAt(i-1)==str.charAt(i)) {
					sum += 5;
				} else {
					sum += 10;
				}
			}
			System.out.println(sum);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P7567();
	}
}