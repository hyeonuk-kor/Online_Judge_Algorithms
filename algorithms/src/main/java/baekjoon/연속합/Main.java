package baekjoon.연속합;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		Reader r = new Reader();
		int n =  r.nextInt();
		int[] memo = new int[n];
		memo[0] = r.nextInt();
		int answer = -1000;
		for(int i=1; i<n; i++) {
			int number = r.nextInt();
			memo[i] = Math.max(memo[i-1]+number, number);
			answer = Math.max(answer, memo[i]);
		}
		System.out.println(answer);
	}
	static class Reader {
		StreamTokenizer st;
		public Reader() {
			st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		}
		int nextInt() throws Exception {
			st.nextToken();
			return (int)st.nval;
		}
	}
}