package swexperts.요리사;
import java.io.*;
import java.util.*;
public class Solution {
	static int N, answer;
	static int[][] table = new int[17][17];
	static boolean[] visit = new boolean[17];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j=1; j<=N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			rec_func(1, N, N/2);
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void rec_func(int start, int end, int r) {
		if(r==0) { // N/2개를 고른 경우
			int sum = getResult();
			answer = Math.min(sum, answer);
			return;
		} else {
			for(int i=start; i<=N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					rec_func(i+1, end, r-1);
					visit[i] = false;
				}
			}
		}
	}
	static int getResult() {
		ArrayList<Integer> team1 = new ArrayList<>();
		ArrayList<Integer> team2 = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			if(visit[i])
				team1.add(i);
			else
				team2.add(i);
		}
		int t1_sum = 0;
		for(int i=0; i<team1.size()-1; i++) {
			for(int j=i+1; j<team1.size(); j++) {
				t1_sum += table[team1.get(i)][team1.get(j)];
				t1_sum += table[team1.get(j)][team1.get(i)];
			}
		}
		int t2_sum = 0;
		for(int i=0; i<team2.size()-1; i++) {
			for(int j=i+1; j<team2.size(); j++) {
				t2_sum += table[team2.get(i)][team2.get(j)];
				t2_sum += table[team2.get(j)][team2.get(i)];
			}
		}
		return Math.abs(t1_sum-t2_sum);
	}
}
