package swexperts.최적경로_1247;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, p[]; // N : 고객집 수, p : 고객집의 순서를 만들 순열용 배열
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			
			N = Integer.parseInt(br.readLine());
			int[][] customers = new int[N][2]; // N명의 고객집 좌표
			int[][] distance = new int[N+2][2]; // 회사(0), N명의 고객좌표(순열로 순서 결정:1-N), 집 좌표(N+1)
			p = new int[N];
			int min= Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			distance[0][0] = Integer.parseInt(st.nextToken()); // 회사
			distance[0][1] = Integer.parseInt(st.nextToken());
			distance[N+1][0] = Integer.parseInt(st.nextToken()); // 집
			distance[N+1][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
				p[i] = i+1;
			}
			// p 배열 = {1,2,3,4,5,...}
			// np 호출 => 1,2,3,5,4
			//       => 1,2,4,3,5
			
			do {
				for (int i = 0; i < N; i++) {
					distance[p[i]] = customers[i];
				}
				int temp = 0;
				for (int i = 0; i <= N ; i++) { // 앞집부터 뒷집(인접한 두 집 처리)
					temp += Math.abs(distance[i][0] - distance[i+1][0]);
					temp += Math.abs(distance[i][1] - distance[i+1][1]);
				}
				if(min>temp) {
					min = temp;
				}
				
			} while(nextPermutation());
			
			System.out.println("#" + t + " " + min);
		}

	}

	//현재 순열의 상태에서 사전순으로 나열했을 때 그 다음 단계의 순열 생성
	// boolean : true = 다음 순열 생성, false => 다음 순열 생성 불가(이미 제일 큰 순열)
	private static boolean nextPermutation() { //최종목표 : 가장 큰 순열 생성
		// 1. 뒤쪽부터 탐색하며 꼭대기(큰 값)를 찾는다. (i) 
		int i = N-1;

		// 1 3 5 4 2 --> 꼭대기는 5, 꼭대기 앞 3(i-1)이 교환대상
		while(i>0 && p[i-1]>=p[i]) {
			--i;
		}
		
		//  i=0 이면 순열 생성 x
		if(i==0) {
			return false;
		} 
		// 2. 뒤쪽에서 탐색하며 교환할 큰 값을 찾는다. (j)
		int j = N-1;
		while( p[i-1]>=p[j]) --j;
		
		// 3. i-1, j 위치값 교환
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		// 맨 뒤부터 꼭대기까지 오름차순으로 바꾼다.
		// 4. i 위치부터 N-1(맨뒤)까지 내림차순 형태의 숫자를 오름차순으로 가장 작은 수로 만들기 위해 정렬(교환)
		int k = N-1;
		while(i<k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		return true;
	}

}