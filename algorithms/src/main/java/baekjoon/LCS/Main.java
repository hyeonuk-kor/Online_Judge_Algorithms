package baekjoon.LCS;
import java.io.*;
import java.util.*;
class LCS {
	int index;
	char subCharacter;
	public LCS(int index, char subCharacter) {
		this.index = index;
		this.subCharacter = subCharacter;
	}
}
public class Main {
	static Map<String, Integer> memo = new HashMap<>();
	static Stack<LCS> stack = new Stack<>();
	static String A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		A = br.readLine();
		B = br.readLine();
		int result = LCS(A.length()-1, B.length()-1);
		bw.append(result+"\n");
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			LCS info = stack.pop();
			if(info.index==result) {
				sb.append(info.subCharacter);
				result--;
			}
		}
		bw.append(sb.reverse());
		bw.flush();
	}
	static int LCS(int lastIdxA, int lastIdxB) {
		int result = 0;
		if(lastIdxA<0 || lastIdxB<0)
			return result;
		String key = lastIdxA + " " + lastIdxB;
		if(memo.containsKey(key))
			return memo.get(key);
		if(A.charAt(lastIdxA)==B.charAt(lastIdxB)) {
			result = 1 + LCS(lastIdxA-1, lastIdxB-1);
			stack.push(new LCS(result, A.charAt(lastIdxA)));
		} else {
			int frontRemove = LCS(lastIdxA-1, lastIdxB);
			int backRemove = LCS(lastIdxA, lastIdxB-1);
			result = Math.max(frontRemove, backRemove);
		}
		memo.put(key, result);
		return result;
	}
}