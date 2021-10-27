package baekjoon.크게만들기;
import java.io.*;
import java.util.*;
public class Main {
	static class P2812 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int K, N;
		char[] arr;
		Stack<Character> stack;
		void solve() {
			input();
			calc();
			getAnswer();
		}
		void getAnswer() {
			sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			StringBuilder answer = new StringBuilder(sb.substring(K)).reverse();
			System.out.println(answer);
		}
		
		void calc() {
			stack = new Stack<>();
			for(int i=0; i<N; i++) {
				while(K>0 && !stack.isEmpty() && stack.peek()<arr[i]) {
					stack.pop();
					K--;
				}
				stack.push(arr[i]);
			}
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				arr = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2812().solve();
	}
}
