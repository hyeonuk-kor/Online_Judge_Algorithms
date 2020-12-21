package baekjoon.괄호;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> s = new Stack<Character>();
		for(int t=1; t<=T; t++) {
			char[] array = br.readLine().toCharArray();
			for(int i=0; i<array.length; i++) {
				if(array[i]=='(') {
					s.push(array[i]);
				} else {
					if(s.isEmpty()) {
						s.push(array[i]);
						break;
					} else if(s.peek()=='('){
						s.pop();
					}
				}
			}
			if(s.isEmpty()) {
				bw.append("YES\n");
			} else {
				bw.append("NO\n");
				s.clear();
			}
		}
		bw.flush();
	}
}