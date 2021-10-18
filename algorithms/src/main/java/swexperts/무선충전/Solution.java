package swexperts.무선충전;
/*
 
시간에 따라 이동하며 2명이 같은 AP가 아닌 서로 다른 AP 선택할 경우 
총합은 적어도 나눠쓴 경우의 총합보다 크거나 같을 것이기 때문에 
DFS를 활용하여 모든 경우를 탐색한다.
정리하면 1 사용자는, 1 셀을 사용한다를 전제로 DFS를 진행한 것임

매 초(T)마다 아래의 DFS를 진행한다.
DFS 정의 : 2명의 사용자가 충전가능한 지역을 탐색하여 T초때의 2명의 충전양을 리턴해주는 함수
DFS 종료조건 : 2명의 사용자가 셀을 선택하거나 못했을 경우
 - 못한 경우는 해당 셀이 충전가능 지역이 아닐 때와 누군가가 선택을 해서 못하는 경우를 동시에 나타냄 [1인 1셀]
진행 조건
 - 충전 거리(문제속 거리 계산 공식)와 누군가가 방문하지 않았을 경우 DFS 탐색 진행 

문제속 시간(M초)동안 DFS를 수행하여 누적 합을 리턴하면 됨
 */

import java.io.*;
import java.util.*;
public class Solution {
	static class BC {
		int x, y, c, p;
		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	static ArrayList<Integer> user1, user2;
	static BC[] ap;
	static int dx[] = {0, 0, 1, 0, -1};
	static int dy[] = {0, -1, 0, 1, 0};
	static int M, A, answer, calc;
	static int u[][] = new int[2][2];
	static boolean visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			user1 = new ArrayList<>();
			for(int i=0; i<M; i++)
				user1.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			user2 = new ArrayList<>();
			for(int i=0; i<M; i++)
				user2.add(Integer.parseInt(st.nextToken()));
			ap = new BC[A];
			visit = new boolean[A];
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap[i] = new BC(x, y, c, p);
			}
			u[0][0] = 1;
			u[0][1] = 1;
			u[1][0] = 10;
			u[1][1] = 10;
			solve();
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void solve() {
		answer = 0;
		int result = 0;
		int index = 0;
		result += selectBC();
		while(M-->0) {
			u[0][0] += dx[user1.get(index)];
			u[0][1] += dy[user1.get(index)];
			u[1][0] += dx[user2.get(index)];
			u[1][1] += dy[user2.get(index)];
			index++;
			result += selectBC();
		}
		answer = result;
	}
	static int selectBC() {
		calc = 0;
		dfs(0, 0);
		return calc;
	}
	static void dfs(int depth, int sum) {
		if(depth==2) {
			calc = Math.max(sum, calc);
			return;
		}
		for(int i=0; i<A; i++) {
			int c = Math.abs(u[depth][0] - ap[i].x) + Math.abs(u[depth][1] - ap[i].y);
			if(!visit[i] && c<=ap[i].c) {
				visit[i] = true;
				dfs(depth+1, sum+ap[i].p);
				visit[i] = false;
			}
		}
		dfs(depth+1, sum);
	}
}