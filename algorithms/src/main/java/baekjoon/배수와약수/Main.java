package baekjoon.배수와약수;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(a!=0 && b!=0) {
			if(a<b) {
				if(b%a==0)
					bw.append("factor").append('\n');
				else
					bw.append("neither").append('\n');
			} else if(a>b) {
				if(a%b==0)
					bw.append("multiple").append('\n');
				else
					bw.append("neither").append('\n');
			}
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		bw.flush();
		bw.close();
	}
}
