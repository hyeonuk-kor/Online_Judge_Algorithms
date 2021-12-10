package baekjoon.초코칩케이크;
import java.io.*;
import java.util.*;
class P23823 {
	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;
	int N, Q, max_row_choco, max_col_choco, answer;
	int max_row_count = 0, max_col_count = 0;
	Map<Integer,Integer> row, col;
	P23823() {
		sb = new StringBuilder();
		row = new HashMap<>();
		col = new HashMap<>();
		input();
		System.out.println(sb);
	}
	void input() {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			for(int q=0; q<Q; q++) {
				st = new StringTokenizer(br.readLine().trim());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken())-1;
				fill(cmd, a);
				sb.append(answer).append('\n');
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void fill(int cmd, int a) {
		if(cmd==1) {
			row.put(a, row.getOrDefault(a, 0)+1);
			if(row.get(a)>max_row_choco) {
				max_row_choco = row.get(a);
				max_row_count = 1;
			} else if(row.get(a)==max_row_choco) {
				max_row_count++;
			}
		} else {
			col.put(a, col.getOrDefault(a, 0)+1);
			if(col.get(a)>max_col_choco) {
				max_col_choco = col.get(a);
				max_col_count = 1;
			} else if(col.get(a)==max_col_choco) {
				max_col_count++;
			}
		}
		if(max_row_count==0) {
			answer = max_col_count * N;
		} else if(max_col_count==0) {
			answer = max_row_count * N;
		} else {
			answer = max_row_count * max_col_count;
		}
	}
}
public class Main {
	public static void main(String[] args) {
		new P23823();
	}
}