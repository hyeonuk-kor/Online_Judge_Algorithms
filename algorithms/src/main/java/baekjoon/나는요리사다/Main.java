package baekjoon.나는요리사다;
import java.io.*;
import java.util.*;
public class Main {
	static class P2953 {
		BufferedReader br;
		StringTokenizer st;
		int number=0, max=0;
		P2953() {
			input();
			System.out.println(number);
			System.out.println(max);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				for(int i=1; i<=5; i++) {
					int sum = 0;
					st = new StringTokenizer(br.readLine().trim());
					for(int j=1; j<=4; j++) {
						sum += Integer.parseInt(st.nextToken());
					}
					if(sum>max) {
						number = i;
						max = sum;
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2953();
	}
}