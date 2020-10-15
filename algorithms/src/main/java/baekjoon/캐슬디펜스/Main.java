package baekjoon.캐슬디펜스;
import java.util.*;
import java.io.*;
public class Main {
	static int N, M, D, map[][], answer;
	static ArrayList<Integer> archers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		archers = new ArrayList<>();
		simulate(0, 0);
		System.out.println(answer);
	} // end main

	static void simulate(int idx, int cnt) {
		//궁수 3명이 선정 되면 아래 내용을 수행
		if(cnt==3) {
			//궁수 초기화
			for(int i=0; i<M; i++) {
				map[N][i] = 0;
			}
			//궁수 배치
			for(int i=0; i<archers.size(); i++) {
				map[N][archers.get(i)] = 1;
			}
			//적 제거
			isAttacking(0);
			return;
		}

		//궁수 자리 선정
		for(int i=idx; i<M; i++) {
			if(archers.contains(i)) continue;
			archers.add(i);
			simulate(i+1, cnt+1);
			archers.remove(cnt);
		}

	}// end simulate

	static void isAttacking(int turn) {
		int cnt = 0;
		int[][] copyMap = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j]=map[i][j];
			}
		}
		while(turn<N) { //모든 적들이 성에 내려올 때 까지만 반복
			boolean[][] visit = new boolean[N][M];
			for(int num=0; num<M; num++) {
				if(map[N][num]==0) continue;
				int r = N;
				int c = num;
				int min_r = 16;
				int min_c = 16;
				int min_d = 11;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(copyMap[i][j]==1) {
							int distance = calcDistance(i, r, j, c);
							if(min_d > distance) {
								min_d = distance;
								min_r = i;
								min_c = j;
							} else if(min_d==distance) {
								if(min_c > j) {
									min_r = i;
									min_c = j;
								}
							}
						}
					}
				}
				
				if(min_d<=D) { 
					visit[min_r][min_c] = true;
				}
			} // 현재 턴에 모든 궁수가 공격을 완료한다.
			
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visit[i][j]) {
						copyMap[i][j]=0; //true 인 경우만 적을 제거한다.
						cnt++;
					}
				}
			}
			
			//100~106 공격 후 적이 내려옴, 
			for(int i=N-2; i>=0; i--) {
				copyMap[i+1] = copyMap[i].clone();
			}
			
			// 맨 윗줄은 내려갔으므로 0으로 만들어준다.
			for(int i=0; i<M; i++) {
				copyMap[0][i] = 0;
			}
			
			// 턴을 증가 시킨다.
			turn++;
		}
		
		//갱신
		if(answer<cnt)
			answer = cnt;
		
	} // end isAttack

	static int calcDistance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}

} // end class
