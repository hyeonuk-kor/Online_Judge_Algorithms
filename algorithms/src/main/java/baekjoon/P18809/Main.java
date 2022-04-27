package baekjoon.P18809;
import java.io.*;
import java.util.*;

public class Main {
	static final int green = 1, red = 2, flower = 3;

	static class P18809 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, G, R, map[][], select[], answer;
		int dy[] = { 0, 0, 1, -1 };
		int dx[] = { 1, -1, 0, 0 };
		boolean check[];
		List<int[]> cand = new ArrayList<>();

		class Info {
			int y, x, state, time;

			public Info(int y, int x, int state, int time) {
				this.y = y;
				this.x = x;
				this.state = state;
				this.time = time;
			}
		}

		P18809() {
			input();
			go(0, 0, 0, 0);
			System.out.println(answer);
		}

		void go(int index, int count, int g, int r) {
			if (count > cand.size())
				return;
			if (g > G || r > R)
				return;
			if (g == G && r == R) {
				getAnswer();
			} else {
				for (int i = index; i < cand.size(); i++) {
					if (!check[i]) {
						check[i] = true;
						select[i] = green;
						go(i, count + 1, g + 1, r);
						select[i] = red;
						go(i, count + 1, g, r + 1);
						select[i] = 0;
						check[i] = false;
					}
				}
			}
		}

		void getAnswer() {
			Queue<Info> q = new ArrayDeque<>();
			Info[][] infoMap = new Info[N][M];
			for (int i = 0; i < N; i++) { // 호수 일 경우 전처리
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						infoMap[i][j] = new Info(i, j, -1, -1);
					} else {
						infoMap[i][j] = new Info(i, j, 0, 0);
					}
				}
			}
			for (int i = 0; i < select.length; i++) { // 배양액 위치를 정해줌
				int[] info = cand.get(i);
				int y = info[0];
				int x = info[1];
				if (select[i] == green) {
					q.add(new Info(y, x, green, 0));
				} else if (select[i] == red) {
					q.add(new Info(y, x, red, 0));
				} else
					continue;
				infoMap[y][x] = new Info(y, x, select[i], 0);
			}
			int count = 0;
			while (!q.isEmpty()) {
				Info info = q.poll();
				int y = info.y;
				int x = info.x;
				int color = info.state;
				int time = info.time;
				if (infoMap[y][x].state == flower)
					continue; // 해당 좌표에 이미 꽃이 핀 경우라면 탐색하지 않음
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (infoMap[ny][nx].state == -1)
						continue; // 호수
					if (infoMap[ny][nx].state == color)
						continue; // 같은 배양액 사용
					if (infoMap[ny][nx].state == flower)
						continue; // 다음 좌표에 이미 꽃이 핀 경우라면 탐색하지 않음
					if (infoMap[ny][nx].state == 0) { // 배양액을 퍼뜨릴 수 있는 경우
						infoMap[ny][nx].state = color; // 상태 저장
						infoMap[ny][nx].time = time + 1; // 1초 후에 퍼진다.
						q.add(new Info(ny, nx, color, time + 1));
					} else if (infoMap[ny][nx].state != color) { // 꽃을 피울 수 있는지 확인
						if (infoMap[ny][nx].time - time != 1)
							continue; // 이전에 처리된 색이 1초 후에 퍼지게 설계되었으므로 차이가 1이 아니라면 x
						count++; // 꽃 카운팅
						infoMap[ny][nx].state = flower; // 해당 좌표를 꽃으로 만든다.
					}
				}
			}
			answer = Math.max(answer, count);
		}

		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				G = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				map = new int[N][M];
				for (int n = 0; n < N; n++) {
					st = new StringTokenizer(br.readLine());
					for (int m = 0; m < M; m++) {
						map[n][m] = Integer.parseInt(st.nextToken());
						if (map[n][m] == 2) {
							cand.add(new int[] { n, m });
						}
					}
				}
				check = new boolean[cand.size()];
				select = new int[cand.size()];
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new P18809();
	}
}