package swexperts.가능한시험점수;
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int number[] = new int[N];
			int result[] = new int[10001];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int max = 0;
			result[0] = 1;
			for(int i=0; i<N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
				max += number[i];
				for(int j=max; j>=0; j--) {
					if(result[j]>0) {
						result[j+number[i]]++;
					}
				}
				result[number[i]]++;
			}
			int answer = 0;
			for(int i=0; i<10001; i++) {
				if(result[i]>0)
					answer++;
			}
			bw.append("#"+tc+" "+answer+'\n');
		}
		bw.flush();
	}
}