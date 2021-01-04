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
			int score[] = new int[N];
			boolean result[] = new boolean[10001];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int max = 0;
			result[0] = true;
			for(int i=0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				max += score[i]; // 점수을 입력받을 때 마다, 가능한 최대 점수를 갱신한다.
				for(int j=max; j>=0; j--) {
					if(result[j]) { //가능 한 점수라면
						result[j+score[i]] = true; //새롭게 입력받았던 점수를 더해가며 체크해준다.
					}
				}
			}
			int answer = 0;
			for(int i=0; i<10001; i++) {
				if(result[i])
					answer++;
			}
			bw.append("#"+tc+" "+answer+'\n');
		}
		bw.flush();
	}
}