package Week1;

class Point {
	int x;
	int y;
	char dir; //방향
	boolean[][][] check; //x, y, 방향체크
	
	public Point(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	void path(char dir) {
		if(dir=='U') {
			y--;
			if(isGoing()) {
				check[x][y][0] = true;  // 올라간다면
				check[x][y+1][1] = true; // 위쪽에서 내려오는 것도 같은 길이므로 true
			} else {
				y++;
			}
		} else if(dir=='D') {
			y++;
			if(isGoing()) {
				check[x][y][1] = true; // 내려간다면
				check[x][y-1][0] = true; // 아래쪽에서 올라가는 것도 같은 길이므로 true
			} else {
				y--;
			}
		} else if(dir=='L') {
			x--;
			if(isGoing()) {
				check[x][y][2] = true;
				check[x+1][y][3] = true;
			} else {
				x++;
			}
		} else { //입력이 4가지만 들어온다는 가정하에
			x++;
			if(isGoing()) {
				check[x][y][3] = true;
				check[x-1][y][2] = true;
			} else {
				x--;
			}
		}
	}
	
	boolean isGoing() {
		if(x>=0 && x < 11 && y>=0 && y<11)
			return true;
		return false;
	}
	
	int calcNewPath() {
		
		int answer = 0;
		
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				for(int k=0; k<4; k++) {
					if(check[i][j][k])
						answer++;
				}
			}
		}
		
		return answer/2; //두번씩 계산했으므로 2로 나눠줌
	}
	
}

public class 방문길이 {
	
	
	
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
	}
	
	
	public static int solution(String dirs) {
        int answer = 0;
		
        Point p = new Point(5, 5, dirs.charAt(0)); //출발준비
        p.check = new boolean[11][11][4];
        
		for(int i=0; i<dirs.length(); i++) {
			p.path(dirs.charAt(i));
		}
		
		return p.calcNewPath();
    }
}
