package baekjoon.어른상어;
import java.io.*;
import java.util.*;
public class Main {
	static class Shark {
		int number, y, x, dir;
		List<ArrayList<Integer>> order;
		boolean exist;
		public Shark(int number, int y, int x, int dir, boolean exist, List<ArrayList<Integer>> order) {
			this.number = number;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.exist = exist;
			this.order = order;
		}
		public int getNumber() {
			return number;
		}
	}
	static final int LOC=0, SMELL=1, TIMETABLE=2;
	static int N, M, K, board[][][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static boolean visit[][];
	static List<Shark> shark = new ArrayList<>(); 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[3][N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[LOC][i][j] = Integer.parseInt(st.nextToken());
				if(board[LOC][i][j]!=0) {
					board[SMELL][i][j]=board[LOC][i][j];
					board[TIMETABLE][i][j]=K;
					shark.add(new Shark(board[LOC][i][j], i, j, 0, true, new ArrayList<>()));
				}
			}
		}
		Collections.sort(shark, Comparator.comparing(Shark::getNumber));
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++)
			shark.get(i).dir = Integer.parseInt(st.nextToken())-1;
		for(int i=0; i<M; i++) {
			for(int j=0; j<4; j++) {
				ArrayList<Integer> dir = new ArrayList<>();
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=0; k<4; k++)
					dir.add(Integer.parseInt(st.nextToken())-1);
				shark.get(i).order.add(dir);
			}
		}
		System.out.println(simulation());
	}
	static int simulation() {
		int time = 0;
		while(time++<1000) {
			visit = new boolean[N][N];
			sharkMovement();
			smellUpdate();
			if(sharkCounting()==1)
				return time;
		}
		return -1;	
	}
	static int sharkCounting() {
		int count = shark.size();
		for(Shark s: shark)
			if(!s.exist)
				count--;
		return count;
	}
	static void sharkMovement() {
		for(int n=0; n<shark.size(); n++) {
			Shark s = shark.get(n);
			if(!s.exist) continue;
			int dir = findDir(s.number, s.y, s.x, s.order.get(s.dir));
			shark.get(n).dir = dir;
			int ny = s.y + dy[dir], nx = s.x + dx[dir];
			board[LOC][s.y][s.x]= 0;
			if(board[LOC][ny][nx]==0) {
				board[LOC][ny][nx] = s.number;
			} else {
				if(board[LOC][ny][nx] > s.number) {
					shark.get(n).exist = false;
				} else {
					for(int i=0; i<shark.size(); i++)
						if(shark.get(i).number==s.number)
							shark.get(i).exist = false;
				}
			}
			visit[ny][nx] = true;
			shark.get(n).y = ny;
			shark.get(n).x = nx;
		}
	}
	static void smellUpdate() {
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(visit[y][x]) {
					board[SMELL][y][x] = board[LOC][y][x];
					board[TIMETABLE][y][x] = K;
				}
				if(!visit[y][x] && board[TIMETABLE][y][x]>0)
					board[TIMETABLE][y][x]--;
			}
		}
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(board[SMELL][y][x]!=0 && board[TIMETABLE][y][x]==0)
					board[SMELL][y][x] = 0;
			}
		}
	}
	static int findDir(int number, int y, int x, ArrayList<Integer> dir) {
		int index = -1;
		for(int i=0; i<dir.size(); i++) {
			int ny = y + dy[dir.get(i)];
			int nx = x + dx[dir.get(i)];
			if(ny<0 || nx<0 || ny>=N || nx>=N)
				continue;
			if(board[SMELL][ny][nx]==0) {
				index = dir.get(i);
				break;
			}
		}
		if(index<0) {
			for(int i=0; i<dir.size(); i++) {
				int ny = y + dy[dir.get(i)];
				int nx = x + dx[dir.get(i)];
				if(ny<0 || nx<0 || ny>=N || nx>=N)
					continue;
				if(board[SMELL][ny][nx]==number) {
					index = dir.get(i);
					break;
				}
			}
		}
		return index;
	}
}