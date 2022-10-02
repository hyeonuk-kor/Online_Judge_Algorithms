package baekjoon.특별한날;
import java.io.*;
public class Main {
	static class P10768 {
		BufferedReader br;
		int m, d;
		String answer;
		P10768() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			if(m==1) {
				answer = "Before";
			} else {
				if(m==2) {
					if(d<18) {
						answer = "Before";
					} else if(d>18) {
						answer = "After";
					} else {
						answer = "Special";
					}
				} else {
					answer = "After";
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				m = Integer.parseInt(br.readLine());
				d = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10768();
	}
}
