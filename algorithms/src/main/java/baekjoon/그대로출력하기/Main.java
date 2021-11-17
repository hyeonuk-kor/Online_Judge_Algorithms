package baekjoon.그대로출력하기;
import java.io.*;
public class Main {
	static class P11718 {
		BufferedReader br;
		StringBuilder sb;
		P11718() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String input = br.readLine();
				while(input!=null && !input.isEmpty()) {
					sb.append(input).append('\n');
					input = br.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P11718();
	}
}