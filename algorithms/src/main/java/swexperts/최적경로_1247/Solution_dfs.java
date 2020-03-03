package swexperts.최적경로_1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_dfs {
	
	static int N; // 고객 집의 수
	static int min, CX, CY, HX, HY; //min : 최소이동거리, CX, CY 회사좌표, HX, HY :집좌표
	static int[][] customers;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine());
			customers = new int[N][2];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st= new StringTokenizer(in.readLine(), " ");
			CX = Integer.parseInt(st.nextToken());
			CY = Integer.parseInt(st.nextToken());
			HX = Integer.parseInt(st.nextToken());
			HY = Integer.parseInt(st.nextToken());
			
			for(int i=0; i< N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			go(0, 0, CX, CY, 0);
			System.out.println("#"+t+" "+min);
		}
		
	}
	
	private static void go(int count, int visited, int bx, int by, int result) {
		
		if(result >= min) { //가지치기 : 기존까지 순열로 처리 중인 고객집들까지 이동했던 거리가 기존 min 값보다 크다면
			return; //더 이상 고객집을 방문해도 이동거리는 커질 수 밖에 없으므로 가지치기한다.
		}
		
		if(count== N) { //기저조건
			result += Math.abs(bx-HX) + Math.abs(by-HY);
			if(min > result)
				min = result;
			return;
		}
		
		for (int i = 0; i < N; i++) { // 모든 고객 집을 다 count 위치에 시도
			if((visited & 1 << i)==0) { // visited & 1 << i : i 고객집이 기존 순열에 처리되었는지 확인 : 0 -> 처리 안됨, 0 아님 -> 처리되었음
				go(count+1, (visited | (1<<i)), customers[i][0], customers[i][1], 
						result+(Math.abs(bx-customers[i][0])+Math.abs(by-customers[i][1])) ); // visited | (1<<i) : 기존 순열상태에 i 고객집 추가
			}
		}
		
	}
	
}