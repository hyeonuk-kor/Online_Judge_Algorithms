package baekjoon.상어초등학교;
import java.util.*;
import java.io.*;
public class Main {
	static int N, map[][], info[][], preference[][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.valueOf(br.readLine());
		map = new int[N][N];
		info = new int[N*N][5];
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) 
				info[i][j] = Integer.valueOf(st.nextToken());
		}
		//자리배치
		map[1][1] = info[0][0];
		for(int i=1; i<N*N; i++) {
			preference = new int[N][N]; //빈 칸이 여러개일 경우 가중치를 구하기 위해 만듦
			for(int j=1; j<5; j++)
				findFriend(info[i][j]); // 주위에 친구가 앉아있는지 찾아주는 함수
			int[] point = getPoint(); // f배열을 이용하여 여러 빈칸들 중 1군데를 정해주는 함수
			map[point[0]][point[1]] = info[i][0]; //앉음
		}
		/*//자리 배치 후 print 
		for(int i=0; i<N; i++)
			System.out.println(Arrays.toString(map[i]));
		*/
		//만족도 조사
		int answer = getSum(); //가중치 구하기
		System.out.println(answer);
	}
	static int getSum() { //가중치 관련
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int count = 0;
				int curIndex = findIndex(map[i][j]); // 정보가 들어있는 인덱스 찾기
				for(int d=0; d<4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(isRange(ny, nx)) {
						for(int k=1; k<5; k++) 
							if(map[ny][nx]==info[curIndex][k])
								count++;
					}
				}
				if(count==1) 		sum += 1;
				else if(count==2)	sum += 10;
				else if(count==3)	sum += 100;
				else if(count==4)	sum += 1000;
			}
		}
		return sum;
	}
	static int findIndex(int number) { // 친구 정보와 관련된 인덱스 찾아주는 함수
		int index = 0;
		for(int i=0; i<N*N; i++)
			if(info[i][0]==number)
				index = i;
		return index;
	}
	static int[] getPoint() {
		int max = 0; // preference 배열에서 가장 큰 숫자(즉, 여러 친구가 함께있을 때 높아졌을 것임)
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				max = Math.max(max, preference[i][j]);

		ArrayList<int[]> list = new ArrayList<int[]>(); // max가 여러개일수도있기에
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				if(preference[i][j]==max && map[i][j]==0)
					list.add(new int[] {i, j, getZero(i, j)}); // y, x , 빈칸의 수

		Collections.sort(list, new Comparator<int[]>() { // 정렬합니다.
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]==o2[2]) { // 빈칸 수가 같다면
					if(o1[0]==o2[0]) // y 좌표 같다면
						return Integer.compare(o1[1], o2[1]); //x가 작은 순
					return Integer.compare(o1[0], o2[0]); // y가 작은 순
				}
				return Integer.compare(o2[2], o1[2]); //빈칸 내림차순을 통한 큰 값 획득
			}
		});
		return new int[] {list.get(0)[0], list.get(0)[1]};
	}
	static int getZero(int y, int x) { // 주위 빈칸의 수를 찾아주는 함수
		int count = 0;
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(!isRange(ny, nx) || map[ny][nx]!=0)
				continue;
			count++;
		}
		return count;
	}
	static void findFriend(int number) { // 주위에 친구가 앉아있는지 찾아주는 함수
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(map[y][x]==number) {
					for(int d=0; d<4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if(!isRange(ny, nx) || map[ny][nx]!=0)
							continue;
						preference[ny][nx]++;
					}
				}
			}
		}
	}
	static boolean isRange(int y, int x) {
		if (x<0 || y<0 || y>=N || x>=N)
			return false;
		return true;
	}
}