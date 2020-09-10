package baekjoon.수정렬하기3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기3 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] check = new int[10001];

		for (int i = 0; i < N; i++) {
			check[Integer.parseInt(br.readLine())]++;
		}

//		StringBuilder sb = new StringBuilder();
		StringBuffer sb = new StringBuffer();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < check.length; i++) {
			while(check[i]-->0)
//				System.out.println(i);
				sb.append(i).append('\n');
//				bw.write(i+"\n");
		}
		System.out.println(sb);
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
	}
}
