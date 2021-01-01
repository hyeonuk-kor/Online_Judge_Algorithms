package baekjoon.끝말잇기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String start = st.nextToken();
		int answer = 1;
		for(int i=1; i<N; i++) {
			String next = st.nextToken();
			if(start.charAt(start.length()-1)!=next.charAt(0)) {
				answer = 0;
				break;
			}
			start = next;
		}
		System.out.println(answer);
	}
}