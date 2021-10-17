package swexperts.줄기세포배양;
import java.io.*;
import java.util.*;
public class answer {
	static class data_type {
		int status; // 0 빈 공간, 1 비활성, 2 활성, 3 죽은상태
		int lp; // lp : life point
		int hp; // hp : 0 죽은상태. 비활성상태일 경우 증가, 활성 상태일 경우 감소
	}
	static int T, N, M, K;
	static data_type[][][] map = new data_type[2][352][352];
	static int dir[][] = { {0, -1}, {0, 1}, {1, 0}, {-1, 0} };
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			for(int i=0; i<N+K+2; i++) {
				for(int j=0; j<M+K+2; j++) {
					map[0][i][j] = new data_type();
					map[1][i][j] = new data_type();
					map[0][i][j].status = 0;
					map[1][i][j].status = 0;
				}
			}
			
			// 초기 줄기세포의 life point
			for(int i=K/2+1; i<N+K/2+1; i++) {
				for(int j=K/2+1; j<M+K/2+1; j++) {
					map[0][i][j].lp = sc.nextInt();
					if(map[0][i][j].lp > 0) {
						map[0][i][j].status = 1;
						map[0][i][j].hp = 0;
					}
				}
			}
			
			// 줄기 세포가 K 시간내에 분포될 수 있는 최대 범위
			N = N + K + 2;
			M = M + K + 2;
			
			int curmap = 0;
			for(int k=0; k<K; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(map[curmap][i][j].status==3) { //죽은 세포일 경우
							map[1-curmap][i][j].status = map[curmap][i][j].status;
							continue; //아무 동작도 하지 않음
						} else if(map[curmap][i][j].status==1) {
							//비활성시간 증가
							map[1-curmap][i][j].hp = map[curmap][i][j].hp + 1;
							map[1-curmap][i][j].lp = map[curmap][i][j].lp;
							// 비활성시간이 lp만큼 지난 경우
							if(map[1-curmap][i][j].hp==map[1-curmap][i][j].lp) {
								//활성상태로 변경
								map[1-curmap][i][j].status = 2;
							} else {
								map[1-curmap][i][j].status = 1;
							}
						} else if(map[curmap][i][j].status==2) { //활성상태일 경우
							//활성 상태가 된 후, 첫 시간일 경우
							if(map[curmap][i][j].hp == map[curmap][i][j].lp) { //expansion
								// 현재위치에서 상하좌우 탐색
								for(int d=0; d<4; d++) {
									int i2, j2;
									i2 = i + dir[d][0];
								    j2 = j + dir[d][1];
								    // 줄기 세포가 번식하는 방향이 비었을 경우
								    if(map[curmap][i2][j2].status == 0) {
								    	// 하나의 줄기세포가 번식하려고 하는 경우
								    	if(map[1-curmap][i2][j2].status==0) {
								    		map[1-curmap][i2][j2].status = 1;
								    		map[1-curmap][i2][j2].lp = map[curmap][i][j].lp;
								    		map[1-curmap][i2][j2].hp = 0;
								    	} else if(map[1-curmap][i2][j2].status==1 && map[1-curmap][i2][j2].lp < map[curmap][i][j].lp) {
								    		// 두 개 이상의 줄기 세포가 셀에 동시에 번식하려는 경우
								    		// 생명력(lp)가 높은 줄기세포가 셀을 차기
								    		map[1-curmap][i2][j2].lp = map[curmap][i][j].lp;
								    	}
								    }
								}
							}
							// 활성시간을 증가
							map[1-curmap][i][j].hp = map[curmap][i][j].hp -1;
							// 활성 상태 시간이 lp 시간 만큼 지났을 경우
							if(map[1-curmap][i][j].hp==0) {
								//줄기 세포가 죽음
								map[1-curmap][i][j].status = 3;
							} else {
								map[1-curmap][i][j].status = 2;
							}
						}
					}
				}
				curmap = 1 - curmap;
			}
			int answer = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[curmap][i][j].status == 1  || map[curmap][i][j].status==2)
						answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
