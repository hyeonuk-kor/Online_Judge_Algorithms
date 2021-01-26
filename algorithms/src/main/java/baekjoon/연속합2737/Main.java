package baekjoon.연속합2737;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int consec = 1;
			int N = Integer.parseInt(br.readLine())-consec;
			int answer = 0;
			while(N>0) {
				consec++;
				N-=consec;
				if(N%consec==0)
					answer++;
			}
			bw.append(answer+"\n");
		}
		bw.flush();
	}
}