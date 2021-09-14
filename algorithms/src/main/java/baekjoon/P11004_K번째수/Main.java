package baekjoon.P11004_K번째수;
import java.io.*;
import java.util.*;
public class Main {
	//실패
	static int number[], N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		number = new int[N];
		for(int i=0; i<N; i++)
			number[i] = (Integer.parseInt(st.nextToken()));
		System.out.println(getK(0, N-1));
	}
	static int getK(int low, int high) {
		int result = -1;
		while(low<=high) {
			int pivot = partition(low, high);
			if(pivot==K-1) {
				result = number[pivot];
				break;
			} else if(pivot > K-1) {
				high = pivot - 1;
			} else {
				low = pivot + 1;
			}
		}
		return result;
	}
	static int partition(int low, int high) {
		int pivot = number[high], pivotloc = low;
		for(int i=low; i<=high; i++) {
			if(number[i]<pivot) {
				int temp = number[i];
				number[i] = number[pivotloc];
				number[pivotloc++] = temp;
			}
		}
		int temp = number[high];
		number[high] = number[pivotloc];
		number[pivotloc] = temp;
		return pivotloc;
	}
}