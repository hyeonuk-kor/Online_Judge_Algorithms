package swexperts.벌꿀채취;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 완전탐색 : 부분집합 --> 조합
public class Solution {

	static int N, M, C; // N: 벌통크기, M: 연속된벌통수, C:채취량
	static int[][] map, maxMap; //map : 입력된 벌통정보, //maxMap: i,j위치에서 가질수 있는 최대 이익

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			maxMap = new int[N][N]; // 0으로 자동 초기화

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine(), " "); //한 행 입력
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			} //end input
			
			//1. 각 i, j 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			
			//2. 두 일꾼의 조합
			System.out.println("#"+t+" "+getMaxBenefit());

		}
	} // end main
	
	private static void makeMaxMap() { //1번 method
		for(int i=0; i<N; i++) {
			for (int j = 0; j <= N-M ; j++) {
				//부분집합 메소드 호출
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	
	// i: 행 위치, j: 열 위치, cnt: 고려한 원소 수,
	// sum : 부분집합에 속한 원소들의 합
	// powSum : 부분집합에 속한 원소의 이익
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) { //부분집합 메소드
		
		//기저 조건(base case)
		if(sum>C) return; //부분집합의 합이 목표량 C를 넘어간다면 리턴, 벌꿀의 양이 음수가 될 수 없으므로 가능함. 가지치기
		
		if(cnt == M) { // 원소수가 부분집합으로 최대로 고려된다면 , sum이 C 이하일 때
			
			//최대이익을 갱신해야한다.
			if(maxMap[i][j-M]<powSum) { //j-M을 빼면 처음에 시작했던 위치를 알 수 있다.
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		//end base case
		
		// i, j 위치 원소 선택
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powSum+map[i][j]*map[i][j]);
		
		// i, j 위치 원소 비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powSum);
	
	}

	private static int getMaxBenefit() {
		int max = 0, temp = 0; // max : 조합적 선택후의 최대 이익값
		
		//1. 일꾼 A를 기준으로 선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) { // A일꾼
				//2. 일꾼 B 선택
				// 같은 행 기준 선택
				for (int j2 = j+M; j2 <= N-M ; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2]; //두 일꾼 조합의 최대 이익
					if(max < temp) {
						max = temp;
					}
				}
				
				// 다음 행 부터 마지막 행까지 선택
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max < temp) {
							max = temp;
						}
					}
				}
			}
		}
		//
		
		return max;
	}
	
}