package baekjoon.오타맨고창영;
import java.io.*;
import java.util.*;
public class Main {
	static class P2711 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N;
		P2711() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				for(int n=0; n<N; n++) {
					st = new StringTokenizer(br.readLine().trim());
					int index = Integer.parseInt(st.nextToken())-1;
					String str = st.nextToken();
					for(int i=0; i<str.length(); i++) {
						if(index!=i) {
							sb.append(str.charAt(i));
						}
					}
					sb.append('\n');
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2711();
	}
}