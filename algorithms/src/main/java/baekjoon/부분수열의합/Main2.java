package baekjoon.부분수열의합;
import java.io.*;
import java.util.*;
public class Main2 {
	static int N, S, number[], count;
	public static void main(String[] args) {
		input();
		rec_func(0, 0);
		if(S==0)
			count--;
		System.out.println(count);
	}
	static void rec_func(int select, int sum) {
		if(select==N) {
			if(sum==S)
				count++;
			return;
		} else {
			rec_func(select+1, sum+number[select]);
			rec_func(select+1, sum);
		}
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			number = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<number.length; i++)
				number[i] = Integer.parseInt(st.nextToken());
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
