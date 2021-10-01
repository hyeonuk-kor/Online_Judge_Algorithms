package baekjoon.연산자끼워넣기;
import java.io.*;
import java.util.*;
public class Main {
	static int N, A[], sign[], selected[], max, min;
	public static void main(String[] args) {
		initialize();
		rec_func(0, A[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static int calculator(int op1, int op, int op2) {
		int sum = 0;
		switch (op) {
			case 0: sum = op1 + op2; break;
			case 1: sum = op1 - op2; break;
			case 2: sum = op1 * op2; break;
			case 3: sum = op1 / op2; break;
		}
		return sum;
	}
	static void rec_func(int depth, int value) {
		if(depth==N-1) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for(int i=0; i<4; i++) {
				if(sign[i]>=1) {
					selected[depth] = i;
					sign[i]--;
					int sum = calculator(value, i, A[depth+1]);
					rec_func(depth+1, sum);
					sign[i]++;
					selected[depth] = 0;
				}
			}
		}
	}
	static void initialize() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			N = Integer.parseInt(br.readLine());
			A = new int[N];
			selected = new int[N];
			sign = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++)
				sign[i] = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}