package swexperts.보호필름;
import java.io.*;
import java.util.*;
public class Solution {
	static int T, D, W, K, answer;
	static int select[] = new int[13];
	static boolean check[] = new boolean[13];
	static int board[][] = new int[13][20];
	static int copy_board[][] = new int[13][20];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(K==1) {
				answer = 0;
			} else {
				injection(0, 0); 
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void injection(int depth, int k) {
		if(D-depth+1<K-k)
			return;
		if(k>answer) // 굳이 할 필요가 없음
			return;
		if(isProtected()) {
			answer = Math.min(answer, k);
			return;
		}
		if(depth==D) // 모든 열 탐색 끝
			return;
		int[] copy = board[depth].clone();
		
		injection(depth+1, k); //약품처리 x
		
		Arrays.fill(board[depth], 0, W, 0); // A로 약품처리
		injection(depth+1, k+1);
		
		Arrays.fill(board[depth], 0, W, 1); // B로 약품처리
		injection(depth+1, k+1);
		
		board[depth] = copy.clone();
	}
	static boolean isProtected() {
		for(int i=0; i<W; i++) {
			boolean check = false;
			int count = 1;
			for(int j=0; j<D-1; j++) {
				if(board[j][i]!=board[j+1][i]) {
					if(count>=K) {
						check = true;
						break;
					} else {
						count = 1;
					}
				} else {
					count++;
				}
			}
			if(count>=K) {
				check = true;
			}
			if(!check)
				return check;
		}
		return true;
	}
}