package baekjoon.십부제;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int count = 0;
		for(int i=0; i<5; i++) {
			int n1 = Integer.parseInt(st.nextToken());
			if(n1==n)
				count++;
		}
		System.out.println(count);
	}
}
