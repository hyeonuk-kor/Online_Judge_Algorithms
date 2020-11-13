package baekjoon.CCW;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x[] = new int[3];
		int y[] = new int[3];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(ccw(x[0],y[0],x[1],y[1],x[2],y[2]));
	}
	static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int temp = x1*y2+x2*y3+x3*y1;
		temp = temp - y1*x2-y2*x3-y3*x1;
		if (temp > 0) {
			return 1;
		} else if (temp < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}