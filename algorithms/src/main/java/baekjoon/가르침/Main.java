package baekjoon.가르침;
import java.io.*;
import java.util.*;
public class Main {
	static class P1062 {
		BufferedReader br;
		StringTokenizer st;
		boolean alpha[];
		String word[];
		int N, K, select[], answer;
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				word = new String[N];
				for(int i=0; i<N; i++) {
					word[i] = br.readLine();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		P1062() {
			alpha = new boolean[26];
			// 먼저 anta, tica를 알아야 모든 단어를 해석할 수 있다.
			alpha['a'-'a'] = true; 
			alpha['n'-'a'] = true;
			alpha['t'-'a'] = true; 
			alpha['i'-'a'] = true;
			alpha['c'-'a'] = true;
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			if(K<5) {
				// anta, tica를 모를 것이다.
				answer = 0;
			} else {
				select = new int[K-4];
				dfs(1);
			}
		}
		void dfs(int depth) {
			if(depth==K-4) {
				int count = 0;
				for(String s: word) {
					boolean check = true;
					for(int i=0; i<s.length(); i++) {
						if(!alpha[s.charAt(i)-'a']) {
							check = false;
							break;
						}
					}
					if(check)
						count++;
				}
				answer = Math.max(answer, count);
			} else {
				for(char c=(char)(select[depth-1]+'a'); c<='z'; c++) {
					if(!alpha[c-'a']) {
						alpha[c-'a'] = true;
						select[depth] = c-'a';
						dfs(depth+1);
						select[depth] = 0;
						alpha[c-'a'] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new P1062();
	}
}