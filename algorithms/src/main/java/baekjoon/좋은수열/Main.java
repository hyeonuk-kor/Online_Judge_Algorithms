package baekjoon.좋은수열;
import java.io.*;
public class Main {
	static int N;
	static String answer = "";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		N = Integer.valueOf(br.readLine());
		getSeq(0, answer);
		pw.append(answer);
		pw.flush();
	}
	static boolean getSeq(int depth, String str) {
		if(depth==N)
			return true;
		if(!check(depth, str)) 
			return false;
		for(int i=1; i<=3; i++) {
			if(getSeq(depth+1, str+i))
				return true;
		}
		return false;
	}
	private static boolean check(int depth, String str) {
		int digit = str.length()/2;
		for(int i=1; i<=digit; i++) {
			
		}
		return true;
	}
}
