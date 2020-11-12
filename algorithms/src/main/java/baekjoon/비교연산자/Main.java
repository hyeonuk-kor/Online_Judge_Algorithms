package baekjoon.비교연산자;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		String cmd = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int tc = 1;
		while(!cmd.equals("E")) {
			bw.append("Case "+(tc++)+": ");
			switch (cmd) {
			case ">":
				bw.append((a>b)+"\n");
				break;
			case ">=":
				bw.append((a>=b)+"\n");
				break;
			case "<":
				bw.append((a<b)+"\n");
				break;
			case "<=":
				bw.append((a<=b)+"\n");
				break;
			case "==":
				bw.append((a==b)+"\n");
				break;
			case "!=":
				bw.append((a!=b)+"\n");
				break;
			}
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			cmd = st.nextToken();
			b = Integer.parseInt(st.nextToken());
		}
		bw.flush();
	}
}
