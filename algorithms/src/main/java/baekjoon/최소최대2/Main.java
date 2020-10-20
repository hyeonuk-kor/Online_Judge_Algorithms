package baekjoon.최소최대2;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int max = -1234567;
			int min = 1234567;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num > max) max = num;
				if(num < min) min = num;
			}
			bw.write(min+" "+max+"\n");
			bw.flush();
		}
		br.close();	bw.close();
	}
}
