package baekjoon.백설공주와일곱난쟁이;
import java.io.*;
public class Main {
	static class P3040 {
		BufferedReader br;
		int dwarf[], sum, no1, no2;
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				for(int i=0; i<9; i++) {
					dwarf[i] = Integer.parseInt(br.readLine());
					sum += dwarf[i];
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		P3040() {
			dwarf = new int[9];
			input();
			solve();
		}
		void findLier() {
			sum-=100;
			for(int i=0; i<8; i++) {
				for(int j=i+1; j<9; j++) {
					if(dwarf[i]+dwarf[j]==sum) {
						no1 = i;
						no2 = j;
						return;
					}
				}
			}
		}
		void solve() {
			findLier();
			for(int i=0; i<9; i++) {
				if(i!=no1 && i!=no2)
					System.out.println(dwarf[i]);
			}
		}
	}
	public static void main(String[] args) {
		new P3040();
	}
}