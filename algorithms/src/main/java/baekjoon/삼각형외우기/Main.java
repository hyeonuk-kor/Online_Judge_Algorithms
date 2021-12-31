package baekjoon.삼각형외우기;
import java.io.*;
public class Main {
	static class P10101 {
		BufferedReader br;
		StringBuilder sb;
		int A, B, C;
		P10101() {
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			if(isTriangle()) {
				if(A==B && B==C) {
					sb.append("Equilateral");
				} else if(A==B || B==C || C==A) {
					sb.append("Isosceles");
				} else {
					sb.append("Scalene");
				}
			} else {
				sb.append("Error");
			}
		}
		boolean isTriangle() {
			return (A+B+C)==180;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				A = Integer.parseInt(br.readLine());
				B = Integer.parseInt(br.readLine());
				C = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10101();
	}
}