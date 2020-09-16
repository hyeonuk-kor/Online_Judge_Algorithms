package baekjoon.좌표정렬하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬하기_객체배열 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] point = new Point[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(point);
		
		for(int i=0; i<N; i++) {
            bw.write(point[i].toString());
		}
		bw.close();
	}
}
