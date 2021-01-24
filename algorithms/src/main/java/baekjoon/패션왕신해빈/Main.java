package baekjoon.패션왕신해빈;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()," ");
				String value = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key,0)+1);
			}
			int answer = 1;
			for(int value: map.values()) {
				answer *= (value+1);
			}
			bw.append(answer-1+"\n");
		}
		bw.flush();
	}
}
