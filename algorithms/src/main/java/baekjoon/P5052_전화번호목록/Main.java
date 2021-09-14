package baekjoon.P5052_전화번호목록;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		next_tc:for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<String>();
			for(int i=0; i<N; i++)
				list.add(br.readLine());
			Collections.sort(list);
			for(int i=0; i<N-1; i++) {
				if(list.get(i+1).startsWith(list.get(i))) {
					bw.append("NO\n");
					continue next_tc;
				}
			}
			bw.append("YES\n");
		}
		bw.flush();
	}
}