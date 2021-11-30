package baekjoon.어항정리;
import java.io.*;
import java.util.*;
public class Main {
	static class P23291 {
		BufferedReader br; StringTokenizer st;
		int N, K, arr[][], arr2[][], answer;
		int dir[][] = {{0,-1}, {1,0}, {0,1}, {-1, 0}};
		Deque<Integer> fishbowl;
		P23291() {
			fishbowl = new ArrayDeque<>();
			input();
			init();
			pro();
			System.out.println(answer);
		}
		void pro() {
			int count = 0;
			while(!isFinished()) {
				count++;
				arrange_fishbowl(); // 1개씩 공중 부양시키면서 정리
				lineUp_fishbowl(arr); // 바닥에 일렬로 놓기
				arrange_fishbowl(N/2); // N/2씩 공중 부양시키면서 정리
				lineUp_fishbowl(arr2); // 바닥에 일렬로 놓기
			}
			answer = count;
		}
		void lineUp_fishbowl(int[][] array) {
			int row_size = array.length;
			int col_size = array[0].length;
			for(int i=0; i<col_size; i++) {
				for(int j=0; j<row_size; j++) {
					if(array[j][i]!=0) {
						fishbowl.addLast(array[j][i]);
						array[j][i] = 0;
					}
				}
			}
		}
		void roll(int y, int x, int d, int number, int size) {
			if(number==0) {
				return;
			} else {
				arr[y][x] = fishbowl.pollLast();
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if(isRange(ny, nx, arr.length, size) || arr[ny][nx]!=0) {
					d = (d+1==4)?0:d+1;
					y += dir[d][0];
					x += dir[d][1];
				} else {
					y = ny;
					x = nx;
				}
				roll(y, x, d, number-1, size);
			}
		}
		void arrange_fishbowl() {
			int y = 0, x = arr[0].length-1, number = N, d=0;
			while(true) { // 제곱수가 나오기 전까지의 전처리
				int root_n = (int)Math.sqrt(number);
				int calc = number - (root_n*root_n);
				if(calc==0) {
					break;
				} else {
					number--;
					arr[y][x] = fishbowl.pollLast();
					y += dir[d][0];
					x += dir[d][1];
				}
			}
			if(isRange(y, x, arr.length, arr[0].length)) {
				y -= dir[d][0];
				x -= dir[d][1];
				d = (d+1==4)?0:d+1;
				y += dir[d][0];
				x += dir[d][1];
			}
			roll(y, x, d, number, (int)Math.sqrt(number)); // 제곱수부터는 말아올리면서 정리하기
			adjust(arr);
		}
		void arrange_fishbowl(int size) {
			for(int j=0; j<size/2; j++) {
				arr2[0][size/2-j-1] = fishbowl.pollLast();
				arr2[1][size/2-j-1] = fishbowl.pollFirst();
			}
			for(int j=0; j<size/2; j++) {
				arr2[2][j] = fishbowl.pollFirst();
				arr2[3][j] = fishbowl.pollLast();
			}
			adjust(arr2);
		}
		void adjust(int[][] array) {
			int r = array.length;
			int c = array[0].length;
			int temp[][] = new int[r][c];
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					for(int d=0; d<4; d++) {
						int ni = i + dir[d][0];
						int nj = j + dir[d][1];
						if(isRange(ni, nj, r, c)) continue;
						if(array[i][j]<=array[ni][nj]) continue;
						if(array[ni][nj]==0) continue;
						int div = (array[i][j] - array[ni][nj]) / 5;
						temp[i][j] -= div;
						temp[ni][nj] += div;
					}
				}
			}
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					array[i][j] += temp[i][j];
					temp[i][j] = 0;
				}
			}
		}
		boolean isRange(int y, int x, int row_size, int col_size) {
			return y<0 || x<0 || y>=row_size || x>=col_size;
		}
		boolean isFinished() {
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int n: fishbowl) {
				min = Math.min(min, n);
				max = Math.max(max, n);
			}
			if(max-min<=K) {
				return true;
			} else {
				Deque<Integer> temp = new ArrayDeque<>();
				while(!fishbowl.isEmpty()) {
					int n = fishbowl.pollFirst();
					if(n==min) {
						temp.add(n+1);
					} else {
						temp.add(n);
					}
				}
				fishbowl = temp;
				return false;
			}
		}
		void init() { // 어항을 정리하는데 필요한 2차원 배열의 사이즈를 구함
			int root_n = (int)Math.sqrt(N);
			int calc = N-(root_n*root_n);
			if(calc==0) {
				arr = new int[root_n][root_n];
			} else if(calc>=root_n) {
				arr = new int[root_n+1][calc];
			} else {
				arr = new int[root_n][root_n+calc];
			}
			arr2 = new int[4][N/4];
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine().trim());
				for(int i=0; i<N; i++)
					fishbowl.add(Integer.parseInt(st.nextToken()));
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23291();
	}
}