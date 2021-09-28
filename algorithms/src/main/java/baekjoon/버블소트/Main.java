package baekjoon.버블소트;
import java.io.*;
import java.util.*;
public class Main {
	static int N, answer;
	static long number[];
	public static void main(String[] args) {
		input();
		number = mergeSort(number);
		System.out.println(answer);
	}
	static long[] mergeSort(long[] array) {
		int mid = array.length/2;
		long[] left = new long[mid];
		long[] right = new long[array.length-mid];
		if(array.length<=1) {
			return array;
		} else {
			// split
			// left
			int index = 0;
			for(index=0; index<left.length; index++)
				left[index] = array[index];
			// right
			for(int i=index; i<array.length; i++)
				right[i-index] = array[i];
			left = mergeSort(left);
			right = mergeSort(right);
		}
		//merge
		return merge(left, right);
	}
	static long[] merge(long[] left, long[] right) {
		long[] array = new long[left.length + right.length];
		int index = 0;
		int left_index = 0;
		int right_index = 0;
		while(left.length > left_index && right.length > right_index) {
			if(left[left_index]>right[right_index]) {
				array[index++] = right[right_index++];
				answer += left.length - left_index;
			} else {
				array[index++] = left[left_index++]; 
			}
		}
		while(left.length > left_index) {
			array[index++] = left[left_index++]; 
		}
		while(right.length > right_index) {
			array[index++] = right[right_index++];
		}
		return array;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			number = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++)
				number[i] = Integer.parseInt(st.nextToken());
		} catch (Exception e) {} 
	}
}
