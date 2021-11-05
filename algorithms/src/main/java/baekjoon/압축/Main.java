package baekjoon.압축;
import java.io.*;
public class Main {
	static class P1662 {
		BufferedReader br;
		String input;
		boolean visit[];
		P1662() {
			input();
			visit = new boolean[input.length()];
			System.out.println(dfs(0));
		}
		int dfs(int index) {
			int result = 0;
			for(int i=index; i<input.length(); i++) {
				if(visit[i]) continue;
				visit[i] = true;
				if(input.charAt(i)=='(') {
					result--;
					result += (input.charAt(i-1)-'0') * dfs(i+1);  
				} else if(input.charAt(i)==')') {
					return result;
				} else {
					result++;
				}
			}
			return result;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1662();
	}
}