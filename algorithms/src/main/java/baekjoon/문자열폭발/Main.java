package baekjoon.문자열폭발;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		char[] result = new char[str.length];
		int index = 0;
		
		for(int i=0; i<str.length; i++) {
			result[index++]=str[i];
			if(str[i]==bomb[bomb.length-1]) {
				int bombIdx = bomb.length-1;
				boolean check = true;
				for (int j = index-1; j >= index-bomb.length; j--) {
					if(j<0 || result[j]!=bomb[bombIdx--]) {
						check = false;
						break;
					}
				}
				if(check)
					index-=bomb.length;
			}
		}

		if(index==0)
			bw.write("FRULA");
		else {
			for (int i = 0; i < index; i++) {
				bw.write(result[i]);
			}
		}

		bw.close();
		
	}
	
}
