package baekjoon.열쇠;
import java.io.*;
import java.util.*;
public class Main {
	static class P9328 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int board_width, board_height, answer, document;
		int dy[] = {0, 0, 1, -1};
		int dx[] = {1, -1, 0, 0};
		char board[][];
		boolean keys[], visit[][][];
		P9328() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				int testcase = Integer.parseInt(br.readLine());
				for(int tc=0; tc<testcase; tc++) {
					keys = new boolean[26];
					st = new StringTokenizer(br.readLine().trim());
					board_height = Integer.parseInt(st.nextToken())+2;
					board_width = Integer.parseInt(st.nextToken())+2;
					board = new char[board_height][board_width];
					visit = new boolean[board_height][board_width][55];
					for(int i=0; i<board.length; i++) {
						Arrays.fill(board[i], '.');
					}
					for(int i=1; i<board_height-1; i++) {
						String input = br.readLine();
						for(int j=1; j<board_width-1; j++) {
							board[i][j] = input.charAt(j-1);
							if(board[i][j]=='$')
								document++;
						}
					}
					String key = br.readLine();
					if(!key.equals("0")) {
						for(char k: key.toCharArray()) {
							keys[k-'a'] = true;
						}
					}
					//process_bfs();
					process_dfs(0, 0, 0);
					sb.append(answer).append('\n');
					answer = 0;
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void process_dfs(int y, int x, int time) {
			if(answer==document)
				return;
			visit[y][x][time] = true;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(isNotRange(ny, nx)) continue;
				if(visit[ny][nx][time])	continue;
				if(board[ny][nx]!='*') {
					boolean check = true;
					if(board[ny][nx]=='$') {
						answer++;
					} else if(board[ny][nx]>='a' && board[ny][nx]<='z') {
						if(!keys[board[ny][nx]-'a']) {
							keys[board[ny][nx]-'a'] = true;
							time++;
						}
					} else if(board[ny][nx]>='A' && board[ny][nx]<='Z') {
						if(!keys[board[ny][nx]-'A'])
							check = false;
					}
					if(check) {
						board[ny][nx] = '.';
						process_dfs(ny, nx, time);
					}
				}
			}
		}
		void process_bfs() {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {0, 0, 0});
			visit[0][0][0] = true;
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int cy = info[0];
				int cx = info[1];
				int time = info[2];
				for(int d=0; d<4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if(isNotRange(ny, nx))
						continue;
					if(board[ny][nx]=='*')
						continue;
					if(visit[ny][nx][time])
						continue;
					if(board[ny][nx]=='$') {
						answer++;
						board[ny][nx] = '.';
						q.add(new int[] {ny, nx, time});
						visit[ny][nx][time] = true;
					} else if(board[ny][nx]>='a' && board[ny][nx]<='z') {
						if(!keys[board[ny][nx]-'a']) {
							keys[board[ny][nx]-'a'] = true;
							time++;
						}
						board[ny][nx] = '.';
						q.add(new int[] {ny, nx, time});
						visit[ny][nx][time] = true;
					} else if(board[ny][nx]>='A' && board[ny][nx]<='Z') {
						if(keys[board[ny][nx]-'A']) {
							time++;
							board[ny][nx] = '.';
							q.add(new int[] {ny, nx, time});
							visit[ny][nx][time] = true;
						}
					} else if(board[ny][nx]=='.') {
						q.add(new int[] {ny, nx, time});
						visit[ny][nx][time] = true;
					}
				}
			}
		}
		boolean isNotRange(int y, int x) {
			return y<0 || x<0 || y>=board_height || x>=board_width;
		}
	}
	public static void main(String[] args) {
		new P9328();
	}
}