package baekjoon.대표값2;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] number = new int[5];
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			number[i] = Integer.parseInt(br.readLine());
			sum += number[i];
		}
		
		Arrays.sort(number);
		System.out.println(sum/5);
		System.out.println(number[2]);
	}
}
