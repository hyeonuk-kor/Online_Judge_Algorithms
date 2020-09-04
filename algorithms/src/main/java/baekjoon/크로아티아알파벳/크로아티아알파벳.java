package baekjoon.크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		String[] check = {
				"c=",
				"c-",
				"dz=",
				"d-",
				"lj",
				"nj",
				"s=",
				"z=",
		};
		
 		for(String s: check) {
			if(str.contains(s)) {
				str = str.replace(s, "a");
			}
		}
 		System.out.println(str.length());
	}
}
