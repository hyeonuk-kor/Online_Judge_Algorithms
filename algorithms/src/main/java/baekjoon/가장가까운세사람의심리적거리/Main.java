package baekjoon.가장가까운세사람의심리적거리;
import java.io.*;
import java.util.*;
public class Main {
	static int[] number;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			char[][] mbti = new char[N][4];
			for(int i=0; i<N; i++) 
				mbti[i] = st.nextToken().toCharArray();
			number = new int[3];
			check = new boolean[N];
			getResult(mbti, 0, N);
			System.out.println();
		}
	}

	static void getResult(char[][] mbti, int index, int N) {
		if(index==number.length) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=index; i<N; i++) {
			if(check[i]) continue;
			check[i] = true;
			number[index] = i;
			getResult(mbti, index+1, N);
			check[i] = false;
		}
	}
}
