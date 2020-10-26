package baekjoon.팰린드롬수;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		while(!N.equals("0")) {
			if(check(N, 0, N.length()-1))
				bw.append("yes");
			else
				bw.append("no");
			N = br.readLine();
			bw.append('\n');
		}
		bw.flush();
		bw.close();
	}

	private static boolean check(String n, int i, int j) {
		if(i>=j) 
			return true;
		
		if(n.charAt(i) == n.charAt(n.length()-i-1))
			return check(n, i+1, j-1);
		return false;
	}

}

