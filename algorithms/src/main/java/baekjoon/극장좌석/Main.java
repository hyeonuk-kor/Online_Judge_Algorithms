package baekjoon.극장좌석;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int seat[] = new int[N+1];
		seat[0] = 1;
		seat[1] = 1;
		for(int i=2; i<N+1; i++) 
			seat[i] = seat[i-1] + seat[i-2];
		int M = Integer.parseInt(br.readLine());
		int answer = 1;
		int prefixedSeatNumber = 0;
		for(int i=0; i<M; i++) {
			int fixedSeatNumber = Integer.parseInt(br.readLine());
			answer *= seat[fixedSeatNumber-prefixedSeatNumber-1];
			prefixedSeatNumber = fixedSeatNumber;
		}
		answer *= seat[N-prefixedSeatNumber];
		System.out.println(answer);
	}
}