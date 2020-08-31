package baekjoon.최소최대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소최대 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int min = Integer.parseInt(st.nextToken());
		int max = min;
		for(int i=1; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(min > num ) min = num;
			if(max < num) max = num;
		}

		System.out.println(min+" "+max);

	}

}
