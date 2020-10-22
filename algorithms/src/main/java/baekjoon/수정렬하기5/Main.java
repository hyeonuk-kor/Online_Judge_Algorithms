package baekjoon.수정렬하기5;
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
		for(int i=0; i<N; i++)
			bw.append(arr[i]+"\n");
		bw.flush();
		bw.close();
	}
}
