package baekjoon.약수;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = 1;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<K; i++) {
			int temp = Integer.parseInt(st.nextToken());
			min = Math.min(temp, min);
			max = Math.max(temp, max);
		}
		bw.append(min*max+"\n");
		bw.flush();
		bw.close();
	}
}
