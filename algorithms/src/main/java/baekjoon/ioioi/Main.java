package baekjoon.ioioi;
import java.io.*;
public class Main {
	static BufferedReader br;
	static PrintWriter pw;
	static int N, M, answer;
	static String S;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		int count_ioi = 0;
		for(int i=1; i<S.length()-1; i++) {
			String s = S.substring(i-1, i+2);
			if(s.equals("IOI")) {
				count_ioi++;
				if(count_ioi==N) {
					count_ioi--;
					answer++;
				}
				i++;
			} else {
				count_ioi = 0;
			}
		}
		pw.print(answer);
		pw.flush();
	}

}
