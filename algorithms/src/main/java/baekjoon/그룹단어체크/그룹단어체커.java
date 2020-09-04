package baekjoon.그룹단어체크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int count = 0;
		for(int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			int[] arr = new int[26];
			arr[str.charAt(0)-97]=1;
			
			int i=0;
			for(i=1; i<str.length(); i++) {
				if(str.charAt(i-1)!=str.charAt(i)) {
					int idx = str.charAt(i)-97;
					if(arr[idx]==0) {
						arr[idx]++;
					} else {
						break;
					}
				}
			}
			if(i==str.length()) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
}
