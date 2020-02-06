class Solution {
	public int solution(String dirs) {
		int answer = 0;
		boolean[][][] c = new boolean[11][11][4];

		int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
		int si=5, sj=5;
		int ni=0, nj=0;

		for(int i=0; i<dirs.length(); i++) {
			if(dirs.charAt(i)=='U') {
				ni = si + dir[0][0];
				nj = sj + dir[0][1];
				if(ni>=0 && ni < 11 && nj>=0 && nj<11) {
					c[ni][nj][0]=true;
					c[si][sj][1]=true;
					si = ni;
					sj = nj;
				}
			} else if(dirs.charAt(i)=='D') {
				ni = si + dir[1][0];
				nj = sj + dir[1][1];
				if(ni>=0 && ni < 11 && nj>=0 && nj<11) {
					c[ni][nj][1]=true;
					c[si][sj][0]=true;
					si = ni;
					sj = nj;
				}
			} else if(dirs.charAt(i)=='R') {
				ni = si + dir[2][0];
				nj = sj + dir[2][1];
				if(ni>=0 && ni < 11 && nj>=0 && nj<11) {
					c[ni][nj][3]=true;
					c[si][sj][2]=true;
					si = ni;
					sj = nj;
				}
			} else if(dirs.charAt(i)=='L') {
				ni = si + dir[3][0];
				nj = sj + dir[3][1];
				if(ni>=0 && ni < 11 && nj>=0 && nj<11) {
					c[ni][nj][2]=true;
					c[si][sj][3]=true;
					si = ni;
					sj = nj;
				}
			}

		}

		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				for(int k=0; k<4; k++) {
					if(c[i][j][k]) answer++;
				}
			}
		}

		return answer/2;
	}
}