package swexperts.두전구;
import java.io.*;
import java.util.*;
public class Solution {
	static boolean bulb[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int min = 100, max = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			min = Math.min(A, C);
			max = Math.max(B, D);
			bulb = new boolean[2][101];
			while(A<=B)
				bulb[0][A++] = true;
			while(C<=D)
				bulb[1][C++] = true;
			int answer = 0;
			while(min<=max) {
				if(bulb[0][min]&bulb[1][min])
					answer++;
				min++;
			}
			if(answer!=0)
				answer--;
			System.out.println("#"+tc+" "+answer);
		}
	}
}