package baekjoon;
import java.io.*;
import java.util.*;
public class Main {
	static class P4101 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				while(true) {
					st = new StringTokenizer(br.readLine().trim());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					if(a==0 && b==0)
						break;
					sb.append(a>b?"Yes":"No").append('\n');
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		P4101() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
	}
	public static void main(String[] args) {
		new P4101();
	}
}