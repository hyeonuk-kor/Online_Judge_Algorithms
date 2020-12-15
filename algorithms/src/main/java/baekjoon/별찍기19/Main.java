package baekjoon.별찍기19;
import java.io.*;
public class Main {
	static BufferedWriter bw;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		printChar('*', 7);
		bw.append('\n');
		printMiddele(5, 7);
		printChar('*', 7);
		bw.flush();
	}
	static void printMiddele(int r, int n) throws Exception {
		if(r>0) {
			bw.append('*'); printChar(' ', n-2); bw.append('*'); bw.append('\n');
			printMiddele(r-1, n);
		}
	}
	static void printChar(char c, int n) throws Exception {
		if(n>0) {
			bw.append(c);
			printChar(c, n-1);
		}
	}
}
