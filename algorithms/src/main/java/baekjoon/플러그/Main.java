package baekjoon.플러그;
import java.io.*;
class P2010 {
	P2010() {
		input();
	}
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			long sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Integer.parseInt(br.readLine()) - 1;
			}	
			sum += Integer.parseInt(br.readLine());
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class Main {
	public static void main(String[] args) {
		new P2010();
	}
}
