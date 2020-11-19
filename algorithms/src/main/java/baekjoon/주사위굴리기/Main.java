package baekjoon.주사위굴리기;
import java.io.*;
import java.util.*;
public class Main {
	static int dice[] = new int[7];
	static int map[][];
	static int dir[][] = { {0,1}, {0,-1}, {-1,0}, {1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		while(--K>=0) {
			int cmd = Integer.parseInt(st.nextToken());
			int ny = y + dir[cmd-1][0];
			int nx = x + dir[cmd-1][1];
			if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
			x = nx;
			y = ny;
			bw.append(getRoll(y, x, cmd)+"\n");
		}
		bw.flush();
	}
	static int getRoll(int y, int x, int cmd) {
		int answer = 0;
		int temp[];
		switch (cmd) {
		case 1: //동쪽
			answer = dice[4];
			if(map[y][x]==0) {
				map[y][x] = dice[3];
			} else {
				dice[3] = map[y][x];
				map[y][x] = 0;
			}
			temp = dice.clone();
									   //
			dice[4] = temp[6]; dice[1] = temp[4]; dice[3]= temp[1];
									   //
							   dice[6] = temp[3];
			break;
		case 2: //서쪽
			answer = dice[3];
			if(map[y][x]==0) {
				map[y][x] = dice[4];
			} else {
				dice[4] = map[y][x];
				map[y][x] = 0;
			}
			temp = dice.clone();
										//
			dice[4] = temp[1];	dice[1] = temp[3]; dice[3] = temp[6];
										//
								dice[6] = temp[4];
			break;
		case 3: //북쪽
			answer = dice[5];
			if(map[y][x]==0) {
				map[y][x] = dice[2];
			} else {
				dice[2] = map[y][x];
				map[y][x] = 0;
			}
			temp = dice.clone();
			dice[2] = temp[1];
			dice[1] = temp[5];
			dice[5] = temp[6];
			dice[6] = temp[2];
			break;
		case 4: //남쪽
			answer = dice[2];
			if(map[y][x]==0) {
				map[y][x] = dice[5];
			} else {
				dice[5] = map[y][x];
				map[y][x] = 0;
			}
			temp = dice.clone();
			dice[2] = temp[6];
			dice[1] = temp[2]; 
			dice[5] = temp[1];	
			dice[6] = temp[5];
			break;
		}
		return answer;
	}
}
