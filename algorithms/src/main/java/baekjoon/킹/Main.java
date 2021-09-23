package baekjoon.킹;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		char[] king = st.nextToken().toCharArray();
		char[] stone = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			String cmd = br.readLine();
			char[] next_king = king.clone();
			char[] next_stone = stone.clone();
			move(cmd, next_king);
			if(range(next_king))
				continue;
			if(Arrays.equals(next_king, next_stone)) {
				move(cmd, next_stone);
				if(range(next_stone))
					continue;
			}
			king = next_king;
			stone = next_stone;
		}
		System.out.println((king));
		System.out.println((stone));
	}
	static boolean range(char[] next) {
		return (next[0]<'A' || next[0]>'H' || next[1]<'1' || next[1]>'8');
	}
	static void move(String cmd, char[] next) {
		switch (cmd) {
			case "R": next[0]++; break;
			case "L": next[0]--; break;
			case "B": next[1]--; break;
			case "T": next[1]++; break;
			case "RT": next[0]++; next[1]++; break;
			case "LT": next[0]--; next[1]++; break;
			case "RB": next[0]++; next[1]--; break;
			case "LB": next[0]--; next[1]--; break;
		}
	}
}