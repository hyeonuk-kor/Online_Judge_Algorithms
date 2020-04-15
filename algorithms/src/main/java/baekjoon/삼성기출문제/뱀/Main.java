package baekjoon.삼성기출문제.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

class dirInfo {
	int time;
	char dir;
	
	public dirInfo(int time, char dir) {
		this.time = time;
		this.dir = dir;
	}

	public int getTime() {
		return time;
	}

	public char getDir() {
		return dir;
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

public class Main {
	
	private static int N;
	private static int answer;
	private static Point head, tail;
	private static LinkedHashSet<Point> set;
	private static int currentX, currentY;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		dirInfo[] timeTable = new dirInfo[L];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			timeTable[i] = new dirInfo(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		int[][] direction = { {-1, 0}, {0,1}, {1,0}, {0,-1} };
		int currentIndex = 1; // direction Index [0: up], [1: right], [2: down], [3: left]

		head = new Point(currentX, currentY);
		tail = new Point(currentX, currentY);
		
		set = new LinkedHashSet<Point>();
		set.add(tail);
		int idx = 0;

		for(int i=0;i<=10000; i++) {
			if(idx < timeTable.length) {
				if(i==timeTable[idx].getTime()) { // 시간이 되었을 때 방향전환
					switch (timeTable[idx].getDir()) {
						case 'D':
							currentIndex = currentIndex>=3?0:++currentIndex;
							break;
						default:
							currentIndex = currentIndex<=0?3:--currentIndex;
							break;
					}
					idx++;
				}
			}
			
			if(isRange(currentX, currentY)) { // 이동하려는 좌표가 맵 내부일때만
				if(board[currentY][currentX]==1) { //사과가 있다면
					board[currentY][currentX]=0; //사과를 먹음
					snakeMove();
				} else { //사과가 없다면
					if(set.size()==1) { //뱀의 머리와 꼬리가 같은 경우, 최초상태
						set.remove(head);
						head.setX(currentX);
						head.setY(currentY);
						set.add(new Point(currentX, currentY));
					} else { 
						for(Iterator<Point> it = set.iterator(); it.hasNext();) {
							Point value = it.next();
							if(value.getX()==tail.getX() && value.getY()==tail.getY()) {
								it.remove(); //사과가 없으므로 꼬리부분을 자른다.
							}
						}
						snakeMove();
					}
				}
			} else {
				answer = i;
			}
			
			currentY += direction[currentIndex][0];
			currentX += direction[currentIndex][1];	
			
			for(Iterator<Point> it = set.iterator(); it.hasNext();) { //다음 좌표가 뱀의 몸과 충돌하는 경우를 체크
				Point value = it.next();
				if(value.getX()==currentX && value.getY()==currentY) {
					answer = i+1; //다음 초에 게임 over 
				}
			}
			
			if(answer!=0)
				break;
		}
		
		System.out.println(answer);
	}

	private static boolean isRange(int currentX, int currentY) {
		return currentX >=0 && currentX <N && currentY >=0 && currentY < N;
	}
	
	private static void snakeMove() {
		int index = 0;
		for(Point t : set) {
			if(index==0) {
				tail.setX(t.getX());
				tail.setY(t.getY());
			}
			if(index==set.size()-1) {
				head.setX(currentX);
				head.setY(currentY);
				set.add(new Point(currentX, currentY)); //머리를 늘린다.
			}
			index++;
		}
	}

}
