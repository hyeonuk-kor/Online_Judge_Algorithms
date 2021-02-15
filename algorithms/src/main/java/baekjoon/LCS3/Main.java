package baekjoon.LCS3;
import java.io.*;
public class Main {
	static int memo[][][] = new int[101][101][101];
	static String A, B, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		A = br.readLine();
		B = br.readLine();
		C = br.readLine();
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				for(int k=0; k<101; k++) {
					memo[i][j][k]=-1;
				}
			}
		}
		int result = LCS(A.length()-1, B.length()-1, C.length()-1);
		bw.append(result+"\n");
		bw.flush();
	}
	static int LCS(int lastIdxA, int lastIdxB, int lastIdxC) {
		int result = 0;
		if(lastIdxA<0 || lastIdxB<0 || lastIdxC<0)
			return result;
		if(memo[lastIdxA][lastIdxB][lastIdxC]!=-1)
			return memo[lastIdxA][lastIdxB][lastIdxC];
		if(A.charAt(lastIdxA)==B.charAt(lastIdxB) && B.charAt(lastIdxB)==C.charAt(lastIdxC)) {
			result = 1 + LCS(lastIdxA-1, lastIdxB-1, lastIdxC-1);
		} else {
			int sub1 = LCS(lastIdxA-1, lastIdxB, lastIdxC);
			int sub2 = LCS(lastIdxA, lastIdxB-1, lastIdxC);
			int sub3 = LCS(lastIdxA, lastIdxB, lastIdxC-1);
			int sub4 = LCS(lastIdxA, lastIdxB-1, lastIdxC-1);
			int sub5 = LCS(lastIdxA-1, lastIdxB, lastIdxC-1);
			int sub6 = LCS(lastIdxA-1, lastIdxB-1, lastIdxC);
			result = Math.max(sub1, sub2);
			result = Math.max(result, sub3);
			result = Math.max(result, sub4);
			result = Math.max(result, sub5);
			result = Math.max(result, sub6);
		}
		return memo[lastIdxA][lastIdxB][lastIdxC] = result;
	}
}