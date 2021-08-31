package baekjoon.P2902_KMP는왜KMP일까;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		while(st.hasMoreTokens())
			System.out.print(st.nextToken().toCharArray()[0]);
	}
}