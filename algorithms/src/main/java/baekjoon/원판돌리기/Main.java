package baekjoon.원판돌리기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, T;
	static ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
	static boolean check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		T = Integer.valueOf(st.nextToken());
		for(int i=0; i<N; i++) {
			ArrayList<Integer> number =  new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				number.add(Integer.valueOf(st.nextToken()));
			}
			board.add(number);
		}
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			int k = Integer.valueOf(st.nextToken());
			for(int i=x; i<=N; i+=x) 
				Collections.rotate(board.get(i-1), (d==0)?k:-k);
			check = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int number = board.get(i).get(j);
					if(number!=-1) {
						removeNumber(i, j, number);
					}
				}
			}
			if(!check) {
				float sum = 0, count = 0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(board.get(i).get(j)!=-1) {
							count++;
							sum += board.get(i).get(j);
						}
					}
				}
				float avg = sum / count;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(board.get(i).get(j)!=-1) {
							if(board.get(i).get(j)<avg) {
								board.get(i).set(j, board.get(i).get(j)+1);
							} else if(board.get(i).get(j)>avg) {
								board.get(i).set(j, board.get(i).get(j)-1);
							}
						}
					}
				}
			}
		}
		int answer = 0; //최종 정답
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board.get(i).get(j)!=-1)
					answer += board.get(i).get(j);
			}
		}
		System.out.println(answer);
	}
	static void removeNumber(int y, int x, int number) {
		int dy[] = {0,0,1,-1};
		int dx[] = {1,-1,0,0};
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(nx==-1) nx = M-1;
			if(nx==M) nx = 0;
			if(ny<0 || ny>=N || board.get(ny).get(nx)!=number)
				continue;
			if(board.get(y).get(x)!=-1) {
				check = true;
				board.get(y).set(x, -1);
			}
			board.get(ny).set(nx, -1);
			removeNumber(ny, nx, number);
		}
	}
}