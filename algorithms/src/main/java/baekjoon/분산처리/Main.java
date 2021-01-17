package baekjoon.분산처리;
import java.io.*;
import java.util.*;
public class Main {
	static final int[][] digit = {
			{10},{1},{2,4,8,6},{3,9,7,1},{4,6},{5},{6},{7,9,3,1},{8,4,2,6},{9,1}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int answer = digit[a%10][((b-1)%digit[a%10].length)];
			bw.append(answer+"\n");
		}
		bw.flush();
	}
}