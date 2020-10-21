package baekjoon.숫자의신;
import java.util.*;
public class Main {
	static int K, N, number[];
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		number = new int[K];
		arr = new int[N];
		check = new boolean[N];
		for(int i=0; i<K; i++) 
			number[i] = sc.nextInt();
		Arrays.parallelSort(number);
		dfs(0);
	}
	static void dfs(int idx) {
		if(idx==N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(check[i]) continue;
			check[i] = true;
			arr[i] = number[i];
			dfs(idx+1);
			check[i] = false;
		}
	}
}
