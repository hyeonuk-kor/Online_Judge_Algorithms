package baekjoon.이모티콘;
import java.io.*;
import java.util.*;
public class Main {
	static class P14226 {
		int S, answer;
		P14226() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			boolean[][] visit = new boolean[1001][1001];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {1, 0, 0});
			visit[1][0] = true;
			while(!q.isEmpty()) {
				int count = q.peek()[0];
				int clipboard = q.peek()[1];
				int time = q.peek()[2];
				if(count==S) {
					answer = time;
					return;
				} else {
					q.poll();	
				}
				// 1. 저장
				if(count>=1 && count<=1000 && !visit[count][count]) {
					q.add(new int[] {count, count, time+1});
					visit[count][count] = true;
				}
				// 2. 붙여넣기
				if(count+clipboard<=1000 && !visit[count+clipboard][clipboard]) {
					q.add(new int[] {count+clipboard, clipboard, time+1});
					visit[count+clipboard][clipboard] = true;
				}
				// 3. 삭제
				if(count>=1 && !visit[count-1][clipboard]) {
					q.add(new int[] {count-1, clipboard, time+1});
					visit[count-1][clipboard] = true;
				}
				
			}
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				S = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P14226();
	}
}
