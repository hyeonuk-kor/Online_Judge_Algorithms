package baekjoon.P9086;
import java.io.*;
public class Main {
	static class P9086 {
		BufferedReader br;
		StringBuilder sb;
		P9086() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int N = Integer.parseInt(br.readLine());
				for(int n=0; n<N; n++) {
					String str = br.readLine();
					sb.append(str.charAt(0)).append(str.charAt(str.length()-1));
					sb.append('\n');
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P9086();
	}
}