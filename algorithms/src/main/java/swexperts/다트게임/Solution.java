package swexperts.다트게임;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int p=0; p<N; p++) {
				st = new StringTokenizer(br.readLine()," ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				double calc = Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2));
				int score = 10;
				int r = 20;
				while(score>=1) {
					if(calc<=r) {
						sum+=score;
						break;
					} else {
						r+=20;
						score--;
					}
				}
			}
			bw.append("#"+tc+" "+sum+"\n");
		}
		bw.flush();
	}
}