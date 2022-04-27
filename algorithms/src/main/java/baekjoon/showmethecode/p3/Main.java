package baekjoon.showmethecode.p3;
import java.io.*;
import java.util.*;
public class Main {
	static int N, used[], answer;
	static boolean visit[];
	static char selected[];
	static String S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		selected = new char[4];
		visit = new boolean[N+1];
		for(int i=0; i<N; i++) {
			dfs(i, 0);
		}
		System.out.println(answer);
	}
	static void dfs(int idx, int dep) {
		if(idx==S.length()) {
			return;
		} else {
			for(int i=idx; i<S.length(); i++) {
				if(!visit[i]) {
					if(dep==0) {
						if(S.charAt(i)=='W') {
							visit[i] = true;
							selected[dep] = 'W';
							dfs(i+1, dep+1);
							visit[i] = false;
						}
					} else if(dep==1) {
						if(S.charAt(i)=='H') {
							visit[i] = true;
							selected[dep] = 'H';
							dfs(i+1, dep+1);
							visit[i] = false;
						}
					} else if(dep==2) {
						if(S.charAt(i)=='E') {
							visit[i] = true;
							selected[dep] = 'E';
							dfs(i+1, dep+1);
							visit[i] = false;
						}
					} else if(dep==3) {
						if(S.charAt(i)=='E') {
							visit[i] = true;
							answer++;
							answer %= 1000000007;
							selected[dep] = 'E';
							dfs(i+1, dep+1);
							visit[i] = false;
						}
					} else {
						if(S.charAt(i)=='E') {
							visit[i] = true;
							answer++;
							answer %= 1000000007;
							dfs(i+1, dep);
							visit[i] = false;
						}
					}
				}
			}
		}
		
	}
}
