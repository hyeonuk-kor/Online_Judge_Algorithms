package baekjoon.큰수BIG;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int answer = 0;
		for (char c : input.toCharArray()) {
			answer = (answer*10+c-'0')%20000303;
		}
		bw.append(answer+"\n");
		bw.flush();
	}
	
}
