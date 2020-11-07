package baekjoon.킹퀸룩비숍나이트폰;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] answer = {1,1,2,2,2,8};
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] my = new int[answer.length];
		for(int i=0; i<my.length; i++) {
			my[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<my.length; i++) {
			bw.append(answer[i]-my[i]+" ");
		}
		bw.flush();
	}
}
