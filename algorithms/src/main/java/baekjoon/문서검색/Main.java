package baekjoon.문서검색;
import java.io.*;
public class Main {
	static BufferedReader br;
	static PrintWriter pw;
	static String doc, word;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(System.out));
		doc = br.readLine();
		word = br.readLine();
		int answer = 0;
		for(int i=0; i<doc.length(); ) {
			if(i+word.length()>doc.length()) {
				i++;
				continue;
			}
			String s = doc.substring(i, i+word.length());
			if(s.equals(word)) {
				answer++;
				i+=word.length();
			} else {
				i++;
			}
		}
		pw.print(answer);
		pw.flush();
	}
}
