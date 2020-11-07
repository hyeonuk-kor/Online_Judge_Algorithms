package baekjoon.스타트와링크;
import java.io.*;
import java.util.*;
public class 스타트와링크_14889 {
	static int N, min=Integer.MAX_VALUE;
	static int startTeam[], linkTeam[];
	static int[][] number;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				number[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		startTeam = new int[N/2];
		linkTeam = new int[N/2];
		check = new boolean[N];
		getTeam(0, 0);
	}
	private static void getTeam(int start, int idx) {
		if(startTeam[0]>=N/2) {
			System.out.println(min);
			System.exit(0);
		}
		if(idx==N/2) {
			int linkTeamIdx = 0;
			for(int i=0; i<check.length; i++) {
				if(!check[i])
					linkTeam[linkTeamIdx++] = i;
			}
			int startTeamSum = 0, linkTeamSum = 0;
			for(int i=0; i<N/2-1; i++) {
				for(int j=i+1; j<N/2; j++) {
					// startTeam 계산
					int si = startTeam[i], sj = startTeam[j];
					startTeamSum = startTeamSum + number[si][sj] + number[sj][si]; 
					// linkTeam 계산
					int li = linkTeam[i],  lj = linkTeam[j];
					linkTeamSum = linkTeamSum + number[li][lj] + number[lj][li]; 
				}
			}
			min = Math.min(Math.abs(startTeamSum-linkTeamSum), min);
			return;
		}
		for(int i=start; i<N; i++) {
			if(check[i]) continue;
			check[i] = true;
			startTeam[idx] = i;
			getTeam(i+1, idx+1);
			check[i] = false;
		}
	}
}