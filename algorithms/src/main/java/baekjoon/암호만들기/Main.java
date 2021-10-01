package baekjoon.암호만들기;
import java.io.*;
import java.util.*;
public class Main {
	static int L, C, selected[];
	static char input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		input();
		rec_func(1, 0, 0);
		System.out.println(sb.toString());
	}
	static void rec_func(int k, int vowel, int consonant) {
		if(k==L+1) {
			if(vowel==0)
				return;
			if(consonant<2)
				return;
			for(int i=1; i<=L; i++)
				sb.append(input[selected[i]]);
			sb.append('\n');
		} else {
			for(int cand=selected[k-1]+1; cand<=C; cand++) {
				selected[k] = cand;
				char c = input[cand];
				if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
					rec_func(k+1, vowel+1, consonant);
				else
					rec_func(k+1, vowel, consonant+1);
				selected[k] = 0;
			}
		}
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			selected = new int[L+1];
			C = Integer.parseInt(st.nextToken());
			input = new char[C+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=C; i++)
				input[i] = st.nextToken().charAt(0);
			Arrays.sort(input);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}