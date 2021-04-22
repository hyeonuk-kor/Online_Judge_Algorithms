package swexperts.달팽이숫자;
import java.io.*;
public class Solution {
	static int map[][];
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int T = Integer.valueOf(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int size = Integer.valueOf(br.readLine());
			map = new int[size][size];
			draw(0, 0, 0, 1, size);
			pw.println("#"+tc);
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					pw.print(map[i][j]+" ");
				}
				pw.println();
			}
		}
		pw.flush();
	}
	static void draw(int y, int x, int dir, int number, int size) {
		if(number==size*size+1)
			return;
		map[y][x] = number;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(ny<0 || nx<0 || ny>=size || nx>=size || map[ny][nx]!=0) {
			dir++;
			dir%=4;
			ny = y + dy[dir];
			nx = x + dx[dir];
		}
		draw(ny, nx, dir, number+1, size);
	}
}