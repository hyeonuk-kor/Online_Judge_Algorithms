package baekjoon.아;
import java.io.*;
public class Main {
	static class P4999 {
		BufferedReader br;
		String A, B;
		P4999() {
			input();
			pro();
		}
		void pro() {
			if(A.length()>=B.length()) {
                System.out.println("go");
            } else {
                System.out.println("no");
            }
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				A = br.readLine();
				B = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P4999();
	}
}