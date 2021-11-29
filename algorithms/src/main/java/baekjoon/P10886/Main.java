package baekjoon.P10886;
import java.io.*;
class Main {
	static class P10886 {
		BufferedReader br;
		int N, yes, no;
		P10886() {
			input();
			if(yes>no) {
				System.out.println("Junhee is cute!");
			} else {
				System.out.println("Junhee is not cute!");
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				for(int n=0; n<N; n++) {
					int result = Integer.parseInt(br.readLine());
					if(result==0) {
						no++;
					} else {
						yes++;
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10886();
	}
}