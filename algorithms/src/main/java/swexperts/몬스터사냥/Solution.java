package swexperts.몬스터사냥;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			double acd = 0;
			double D = Double.parseDouble(st.nextToken());
			double L = Double.parseDouble(st.nextToken());
			double N = Double.parseDouble(st.nextToken());
			for(int i=0; i<N; i++) {
				acd+=D*(1+i*L/100.0);
			}
			bw.append("#"+tc+" "+(int)acd+"\n");
		}
		bw.flush();
	}
}