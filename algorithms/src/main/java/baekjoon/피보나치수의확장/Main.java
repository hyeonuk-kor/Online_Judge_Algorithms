package baekjoon.피보나치수의확장;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int memo[] = new int[Math.abs(n)+2];
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2; i<memo.length; i++) {
			memo[i] = memo[i-1] + memo[i-2];
			memo[i]%=1000000000;
		}
		if(n<0) {
			bw.append(((n%2==0)?-1:1)+"\n");
			n*=-1;
		} else if(n==0) {
			bw.append(0+"\n");
		} else {
			bw.append(1+"\n");
		}
		bw.append(memo[n]+"\n");
		bw.flush();
	}
}