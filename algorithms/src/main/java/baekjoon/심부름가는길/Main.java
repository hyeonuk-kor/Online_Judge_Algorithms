package baekjoon.심부름가는길;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int time = 0;
		for(int i=0; i<4; i++) {
			time += Integer.parseInt(br.readLine());
		}
		System.out.println(time/60);
		System.out.println(time-(time/60)*60);
	}
}
