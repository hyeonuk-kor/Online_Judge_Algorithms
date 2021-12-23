package baekjoon.과제안내신분;
import java.io.*;
public class Main {
	static class P5597 {
		BufferedReader br;
		boolean attendance[];
		P5597() {
			attendance = new boolean[31];
			input();
			for(int i=1; i<=30; i++) {
				if(!attendance[i])
					System.out.println(i);
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				for(int i=0; i<28; i++) {
					int number = Integer.parseInt(br.readLine());
					attendance[number] = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P5597();
	}
}