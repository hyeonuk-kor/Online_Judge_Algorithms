package baekjoon.네번째점;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 네번째점 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] x = new int[3];
		int[] y = new int[3];

		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		int dx=0, dy=0;

		if(x[0]==x[1])
			dx = x[2];
		else 
			dx = (x[1]==x[2]) ? x[0] : x[1];

		if(y[0]==y[1])
			dy = y[2];
		else 
			dy = (y[1]==y[2]) ? y[0] : y[1];

		System.out.println(dx+" "+dy);
	}

}
