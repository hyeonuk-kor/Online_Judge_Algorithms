package baekjoon.로마숫자만들기;
import java.io.*;
public class Main {
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		check = new boolean[50*N+1];
		for(int i=0; i<=N; i++) {
			for(int v=0; v<=N-i; v++) {
				for(int x=0; x<=N-i-v; x++) {
					int l=N-i-v-x;
					int sum = i*1 + v*5 + x*10 + l*50;
					check[sum]= true; 
				}
			}
		}
		int ans = 0;
		for(int i=0; i<check.length; i++) {
			if(check[i])
				ans++;
		}
		System.out.println(ans);
	}
}
