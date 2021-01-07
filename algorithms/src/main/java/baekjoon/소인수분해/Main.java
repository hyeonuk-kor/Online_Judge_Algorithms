package baekjoon.소인수분해;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		while(N!=1) {
			int f = 2;
			while(N%f!=0) 
				f++;
			N/=f;
			bw.append(f+"\n");
		}
		bw.flush();
	}
}