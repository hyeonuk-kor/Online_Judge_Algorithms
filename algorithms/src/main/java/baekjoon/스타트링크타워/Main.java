package baekjoon.스타트링크타워;
import java.io.*;
import java.util.*;
public class Main {
	static class P1089 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		double answer;
		char number[][][], arr[][];
		P1089() {
			number = new char[10][5][3];
			init();
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			for(int i=0; i<N; i++) {
				int calc = 0, cnt = 0;
				for(int n=0; n<=9; n++) {
					boolean check = true;
					for(int j=0; j<arr.length; j++) {
						for(int k=i*4; k<(i+1)*4-1; k++) {
							if(number[n][j][k-i*4]=='.' && arr[j][k]=='#')
								check = false;
						}
					}
					if(check) {
						calc += n*Math.pow(10, N-i-1);
						cnt++;
					}
				}
				if(cnt==0) {
					sb.append(-1);
					return;
				}
				answer += (double)calc/cnt;
			}
			sb.append(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				arr = new char[5][];
				for(int i=0; i<5; i++)
					arr[i] = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void init() {
			String numbers 
			= "###...#.###.###.#.#.###.###.###.###.###\r\n" + 
					"#.#...#...#...#.#.#.#...#.....#.#.#.#.#\r\n" + 
					"#.#...#.###.###.###.###.###...#.###.###\r\n" + 
					"#.#...#.#.....#...#...#.#.#...#.#.#...#\r\n" + 
					"###...#.###.###...#.###.###...#.###.###";
			StringTokenizer st = new StringTokenizer(numbers);
			while(st.hasMoreTokens()) {
				for(int i=0; i<5; i++) {
					String str = st.nextToken();
					for(int j=0; j<str.length(); j+=4) {
						for(int k=0; k<3; k++) {
							number[j/4][i][k] = str.charAt(j+k);
						}
					}	
				}
			}
			/*
			for(int i=0; i<=9; i++) {
				System.out.println(i);
				for(int j=0; j<5; j++) {
					System.out.println(Arrays.toString(number[i][j]));
				}
				System.out.println();
			}
			 */
		}
	}
	public static void main(String[] args) {
		new P1089();
	}
}