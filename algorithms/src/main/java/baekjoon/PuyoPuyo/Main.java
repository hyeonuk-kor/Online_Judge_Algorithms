package baekjoon.PuyoPuyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static final int row = 12;
	static final int col = 6;
	static char[][] map = new char[row][col];
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for(int i=0; i<row; ++i) {
			map[i] = sc.next().toCharArray();
		}
		
		int answer = 0;
		
		while(true) {
			//상쇄
			boolean flag = false;
			boolean[][] visit = new boolean[row][col];
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(map[i][j]!='.') {
						char curr = map[i][j];
						Stack<int[]> stack = new Stack<>();
						List<int[]> list = new ArrayList<>();
						stack.push(new int[] {i,j});
						list.add(new int[] {i, j});
						visit[i][j] = true;
						while(!stack.isEmpty()) {
							int[] temp = stack.pop();
							for(int k=0; k<4; k++) {
								int ni = temp[0] + di[k];
								int nj = temp[1] + dj[k];
								if(ni >= 0 && ni < row && nj >= 0 && nj < col && !visit[ni][nj]) {
									if(map[ni][nj]==curr) {
										stack.push(new int[] {ni, nj});
										list.add(new int[] {ni, nj});
										visit[ni][nj]=true;
									}
								}
							}
						}										
						if(list.size()>=4) {
							flag = true;
							for(int[] temp : list) {
								map[temp[0]][temp[1]]='.';
							}
						}
					}
				}
			}

			//상쇄 결과
			if(flag)
				answer++;
			else {
				break;
			}
			
			//이동
			for (int i = 0; i < 6; i++) {
		        for (int j = 10; j >= 0; j--) {
		            for (int k = 11; k > j; k--) {
		                if (map[j][i] != '.' && map[k][i] == '.') {
		                    map[k][i] = map[j][i];
		                    map[j][i] = '.';
		                    break;
		                }
		            }
		        }
		    }
			
			
		}
		System.out.println(answer);
		sc.close();
	}
}