package baekjoon.책페이지;
import java.io.*;
public class Main {
	static int answer[] = new int[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int s = 1;
		int t = 1;
		while(s<=N) {
			while(s%10!=0 && s<=N) {
				adjust(s, t);
				s++;
			}
			if(s>N) break;
			while(N%10!=9 && s<=N) {
				adjust(N, t);
				N--;
			}
			int cnt = (N/10 - s/10 + 1);
			for(int i=0; i<=9; i++)
				answer[i] += cnt*t;
			s=s/10;
			N=N/10;
			t=t*10;
		}
		for(int i=0; i<=9; i++)
			pw.print(answer[i]+" ");
		pw.flush();
	}
	static void adjust(int number, int t) {
		while(number>0) {
			answer[number%10] += t;
			number/=10;
		}
	}
}