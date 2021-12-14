package baekjoon.단어수학;
import java.io.*;
import java.util.Arrays;
public class Main {
	static class P1339 {
		BufferedReader br;
		int N, alpha[], result[], count;
		char[][] words;
		boolean[] c1, c2;
		P1339() {
			alpha = new int[26];
			c1 = new boolean[26];
			input();
			c2 = new boolean[26];
			solve();
		}
		void solve() {
			getMaxNumber();
			long sum = 0;
			for(int n=0; n<N; n++) {
				StringBuilder number = new StringBuilder();
				for(char c: words[n]) {
					number.append(result[c-'A']);
				}
				sum += Long.parseLong(number.toString());
			}
			System.out.println(sum);
		}
		void getMaxNumber() {
			result = new int[26];
			Arrays.fill(result, -1);
			for(int i=0; i<26; i++) {
				int rank = 0;
				if(!c1[i])
					continue;
				for(int j=0; j<26; j++) {
					if(!c1[j])
						continue;
					if(i!=j) {
						if(alpha[i]>alpha[j]) {
							rank++;
						}
					}
				}
				if(c2[rank]) {
					while(rank+1<10 && c2[rank])
						rank++;
				}
				result[i] = rank;
				c2[rank] = true;
			}
			for(int i=0; i<result.length; i++) {
				if(result[i]!=-1) {
					result[i] += (10-count);
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				words = new char[N][8];
				for(int n=0; n<N; n++) {
					char[] input = br.readLine().toCharArray();
					int calc = 1;
					for(int i=input.length-1; i>=0; i--) {
						alpha[input[i]-'A'] += calc;
						if(!c1[input[i]-'A'])
							count++;
						c1[input[i]-'A'] = true;
						calc*=10;
					}
					words[n] = input;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	static class P1339_new {
		BufferedReader br;
		int N, alpha[], answer;
		P1339_new() {
			alpha = new int[26];
			input();
			Arrays.sort(alpha);
			int number = 9;
			for(int i=25; i>=0; i--) {
				if(alpha[i]!=0) {
					answer += alpha[i]*number--;
				}
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				for(int n=0; n<N; n++) {
					String word = br.readLine();
					for(int i=0; i<word.length(); i++) {
						int index = word.charAt(i) - 'A';
						alpha[index] += Math.pow(10, word.length()-i-1);  
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//new P1339();
		new P1339_new();
	}
}