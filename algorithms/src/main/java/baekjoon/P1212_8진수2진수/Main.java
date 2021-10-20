package baekjoon.P1212_8진수2진수;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine(), 8);
		System.out.println(Integer.toBinaryString(a));
	}
}