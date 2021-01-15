package baekjoon.스택수열;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int start = 1;
		for(int t=0; t<N; t++) {
			boolean check = false;
			int number = Integer.parseInt(br.readLine());
			while(start<=number) {
				sb.append("+\n");
				s.push(start++);
				check = true;
			}
			while(!s.isEmpty() && s.peek()>=number) {
				sb.append("-\n");
				s.pop();
				check = true;
			}
			if(!check) {
				sb = new StringBuilder("NO");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}