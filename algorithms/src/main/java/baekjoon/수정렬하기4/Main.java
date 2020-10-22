package baekjoon.수정렬하기4;
import java.io.*;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.parallelSort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=N-1; i>=0; i--)
			sb.append(arr[i]).append('\n');
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
