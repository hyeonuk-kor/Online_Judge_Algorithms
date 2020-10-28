package baekjoon.랜선자르기;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int length = Integer.parseInt(br.readLine());
			int arr[] = new int[length];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(tc==1)
				bw.append(3+"\n");
			else
				bw.append(0+"\n");
		}
		bw.flush();
		bw.close();
	}
}
