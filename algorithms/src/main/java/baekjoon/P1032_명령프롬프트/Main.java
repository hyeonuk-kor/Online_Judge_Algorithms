package baekjoon.P1032_명령프롬프트;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] str = new char[N][];
		for(int i=0; i<N; i++)
			str[i] = br.readLine().toCharArray();
		char[] answer = new char[str[0].length];
		int index = -1;
		for(int j=0; j<str[0].length; j++) {
			for(int i=1; i<N; i++) {
				if(str[i-1][j]!=str[i][j]) {
					index = j;
					break;
				}
			}
			if(index==-1)
				answer[j] = str[0][j];
			else {
				answer[j] = '?';
				index=-1;
			}
		}
		System.out.println(answer);
	}
}