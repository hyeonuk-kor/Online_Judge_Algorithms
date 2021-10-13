package baekjoon.토마토;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {

	static int M, N, H;
	static int box[][][];
	static int dir[][] = { {-1,0,0}, {1,0,0}, {0,0,-1}, {0,0,1}, {0,1,0}, {0,-1,0}};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); //가로 m	
		N = Integer.parseInt(st.nextToken()); //세로 n
		H = Integer.parseInt(st.nextToken()); //높이 h
		box = new int[H][N][M];
		int answer = Integer.MIN_VALUE;

		Queue<int[]> q = new LinkedList<>();

		for(int h=0; h<H; h++) {
			for(int y=0; y<N; y++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int x=0; x<M; x++) {
					box[h][y][x] = Integer.parseInt(st.nextToken());
					if(box[h][y][x]==1)
						q.add(new int[] {y, x, h, 0});
				}
			}
		}

		boolean check=false;
		loop:for(int h=0; h<H; h++) {
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(box[h][y][x]==0) {
						check = false;
						break loop;
					}
					else 
						check = true;
				}
			}
		}

		if(!check) {
			while(!q.isEmpty()) {
				int[] tomato = q.poll();

				for(int i=0; i<6; i++) {

					int row = tomato[0] + dir[i][0];
					int col = tomato[1] + dir[i][1];
					int height = tomato[2] + dir[i][2];

					if(range(row, col, height) && box[height][row][col]==0) {
						box[height][row][col]=tomato[3]+1;
						q.add(new int[] {row, col, height, tomato[3]+1});
					}
				}
			}

			loop:for(int h=0; h<H; h++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(box[h][i][j]==0) {
							answer = -1;
							break loop;
						} else {
							if(box[h][i][j]>answer)
								answer = box[h][i][j];
						}
					}
				}
			}
		} else {
			answer = 0;
		}
		System.out.println(answer);

	}

	private static boolean range(int row, int col, int hei) {
		return (0 <= row && row < N) && (0 <= col && col < M) && (0<= hei && hei < H);
	}

}

