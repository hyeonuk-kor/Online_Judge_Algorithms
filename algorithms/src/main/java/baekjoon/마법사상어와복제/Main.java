package baekjoon.마법사상어와복제;
import java.io.*;
import java.util.*;
public class Main {
	static class P23290 {
		BufferedReader br;
		StringTokenizer st;
		int shark_order_dir[][] = new int[64][3]; // 상어의 이동 우선순위
		int M, S;
		int shark[][] = new int[4][4];	// 상어 정보
		boolean time[][][]; // 냄새 유지 시간 기록
		int shark_dy[] = {-1, 0, 1, 0}; 
		int shark_dx[] = { 0,-1, 0, 1};
		int fish_dy[] = {0,-1,-1,-1, 0, 1, 1, 1};
		int fish_dx[] = {-1,-1, 0, 1, 1, 1, 0,-1};
		ArrayList<ArrayList<ArrayList<Integer>>> fish;
		ArrayList<ArrayList<ArrayList<Integer>>> next_fish;
		ArrayList<ArrayList<ArrayList<Integer>>> baby_fish;
		
		void init() { // 초기 설정함수에서는 상어의 우선순위와 물고기를 담을 ArrayList를 초기화 합니다.
			// 상어의 우선순위
			int count = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					for(int k=0; k<4; k++) {
						shark_order_dir[count++] = new int[] {i, j, k};
					}
				}
			}
			// 물고기를 담을 공간
			fish = new ArrayList<>();
			next_fish = new ArrayList<>();
			baby_fish = new ArrayList<>();
			for(int i=0; i<4; i++) {
				fish.add(new ArrayList<>());
				next_fish.add(new ArrayList<>());
				baby_fish.add(new ArrayList<>());
				for(int j=0; j<4; j++) {
					fish.get(i).add(new ArrayList<>());
					next_fish.get(i).add(new ArrayList<>());
					baby_fish.get(i).add(new ArrayList<>());
				}
			}
		} // end 초기설정
		
		void solve() { // 문제를 해결하는 함수
			init(); //초기설정 불러오기
			input(); // 입력가져오기 
			int t = 0;
			while(t<S) { // S번 마법 연습하기
				moveFish(t); // 물고기 이동
				int find_dir = getMaxDir(); // 상어가 많이 먹을 수 있는 dir 찾기
				eat(find_dir, t); // 진짜로 먹기
				eggGenerate(); // 알 부화시키기
				t++;
			}
			
			int sum = 0;	// 남은 물고기 계산하기
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					sum += fish.get(i).get(j).size(); // 합 구하기
				}
			}
			
			System.out.println(sum);
			
		}
		void moveFish(int t) { // 물고기 이동 함수
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					for(int d=0; d<fish.get(i).get(j).size(); d++) { // 현재 격자에 있는 모든 물고기를 옮깁니다.
						int fish_dir = fish.get(i).get(j).get(d); // 격자 i, j의 d번째 물고기의 방향
						baby_fish.get(i).get(j).add(fish_dir); // 알을 낳기 위에 baby_fish에 넣어줍니다.
						boolean check = false; // 8방향을 다 탐색해도 갈 곳이 없는지 확인합니다.
						for(int nd=fish_dir+16; nd>fish_dir+8; nd--) { // 반시계 방향을 돌면서 탐색하기 위한 반복문
							int dir = nd%8;								// 8로 나눈 나머지로 치환합니다.
							int ny = i + fish_dy[dir];
							int nx = j + fish_dx[dir];
							if(ny<0 || nx<0 || ny>=4 || nx>=4)	// 경계 벗어나면 이동 불가
								continue;
							if(shark[ny][nx]==1)				// 상어면 이동 불가
								continue;
							if((t>=1 && time[t-1][ny][nx]) || (t>=2 && time[t-2][ny][nx]))					// 사체가 있을 경우 이동 불가
								continue;
							next_fish.get(ny).get(nx).add(dir); // 이동이 가능합니다.
							check = true;						// 위에서 선언한 check를 true로 변경!
							break;
						}
						if(!check) {							// 만약 8방향을 다 탐색해도 갈 수 없다면?
							next_fish.get(i).get(j).add(fish_dir);	// 제자리에 물고기를 둡니다.
						}
					}
				}
			}
			fish = new ArrayList<>(next_fish); // 다음 스텝의 fish맵을 다시 복사합니다.
			next_fish = new ArrayList<>(); // 다음 스탭을 초기화합니다.
			for(int i=0; i<4; i++) {
				next_fish.add(new ArrayList<>());
				for(int j=0; j<4; j++) {
					next_fish.get(i).add(new ArrayList<>());
				}
			}
		}
		int getMaxDir() { // 상어가 먹기전에 가장 많이 먹을 수 있는 방향을 탐색!
			// 상어 위치를 찾습니다.
			int y = 0, x = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(shark[i][j]==1) {
						y = i;
						x = j;
					}
				}
			}
			// 초기 설정에서 방향을 저장해둔 것을 이용하여, 가장 많은 물고기의 사이즈를 찾습니다.
			int max = -1;	
			int max_dir = 0; 
			loop:for(int d=0; d<shark_order_dir.length; d++) {
				int sum = 0;
				int ny = y; 
				int nx = x; 
				// 항상 출발은 y, x에서 시작해야해서 복사해둡니다.
				boolean visit[][] = new boolean[4][4];
				// 중복 계산을 막기 위해, 방문처리합니다.
				//visit[ny][nx] = true;
				// 아래 반복문은 이동시켜보며, 먹을 수 있는 물고기의 양을 계산합니다.
				for(int f=0; f<3; f++) {
					ny += shark_dy[shark_order_dir[d][f]];
					nx += shark_dx[shark_order_dir[d][f]];
					if(ny<0 || nx<0 || ny>=4 || nx>=4)
						continue loop;
					if(!visit[ny][nx]) {
						sum += fish.get(ny).get(nx).size();
						visit[ny][nx] = true;
					}
				}
				// 갱신
				if(sum>max) {
					max = sum;
					max_dir = d;
				}
			}
			return max_dir; // 방향 찾음!
		}
		void eat(int find_dir, int t) { // 많이 먹을 수 있는 방향을 받아, 먹이기
			// 상어 찾기
			int y = 0, x = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(shark[i][j]==1) {
						y = i;
						x = j;
					}
				}
			}
			
			// 상어의 이동 시작
			shark[y][x] = 0;
			for(int d=0; d<3; d++) {
				y += shark_dy[shark_order_dir[find_dir][d]];
				x += shark_dx[shark_order_dir[find_dir][d]];
				if(!fish.get(y).get(x).isEmpty()) { // 격자에 물고기가 있다면
					fish.get(y).get(x).clear(); // 모두 먹어치웁니다.
					time[t][y][x] = true;
				}
			}
			shark[y][x] = 1; // 이동 끝
		}
		void eggGenerate() {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					for(int k=0; k<baby_fish.get(i).get(j).size(); k++) {
						fish.get(i).get(j).add(baby_fish.get(i).get(j).get(k)); // moveFish()에서 낳앗던 알을 부화시킵니다.
					}
					baby_fish.get(i).get(j).clear(); // 재사용을 위해 clear
				}
			}
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				M = Integer.parseInt(st.nextToken());
				S = Integer.parseInt(st.nextToken());
				time = new boolean[S][4][4];
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int y = Integer.parseInt(st.nextToken())-1;
					int x = Integer.parseInt(st.nextToken())-1;
					int d = Integer.parseInt(st.nextToken())-1;
					fish.get(y).get(x).add(d);
				}
				st = new StringTokenizer(br.readLine().trim());
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				shark[y][x] = 1;
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23290().solve();
	}
}