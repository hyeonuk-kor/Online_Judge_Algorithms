package baekjoon.파일정리;
import java.io.*;
import java.util.*;
public class Main {
	static class P20291 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		String extension[];
		String solve() {
			input();
			Arrays.sort(extension);
			int count = 1;
			String ext = extension[0];
			for(int i=1; i<N; i++) {
				if(ext.equals(extension[i])) {
					count++;
				} else {
					sb.append(ext).append(' ').append(count).append('\n');
					ext = extension[i];
					count = 1;
				}
			}
			sb.append(ext).append(' ').append(count).append('\n');
			return sb.toString();
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				extension = new String[N];
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine(), ".");
					st.nextToken();
					extension[i] = st.nextToken();
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P20291().solve());
	}
}
