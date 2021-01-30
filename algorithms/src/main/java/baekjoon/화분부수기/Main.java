package baekjoon.화분부수기;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int pot[] = new int[3];
		boolean broken[] = new boolean[1000001];
		int answer = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
				pot[j]=Integer.parseInt(st.nextToken());
			if(!broken[pot[0]] && !broken[pot[1]] && !broken[pot[2]])
				answer++;
			broken[pot[0]] = broken[pot[1]] = broken[pot[2]] = true;
		}
		System.out.println(answer);
	}
}
