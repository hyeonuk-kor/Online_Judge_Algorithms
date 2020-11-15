package baekjoon.랜선자르기;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] l = new int[K];
		for(int i=0; i<K; i++) {
			l[i] = Integer.parseInt(br.readLine());
		}
		Arrays.parallelSort(l);
		long start = 1;
		long end = l[K-1];
		while(start<=end) {
			long mid = (start+end)/2;
			int count = 0;
			for(int i=0; i<K; i++) {
				count += (l[i]/mid);
			}
			if(count<N) {
				end = mid-1;
			} else if(count>=N) {
				start = mid+1;
			}
		}
		bw.append(end+"");
		bw.flush();
	}
}
