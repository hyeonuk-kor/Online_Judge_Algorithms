package baekjoon.ppap;
import java.io.*;
import java.util.*;
class P16120 {
	String str;
	P16120() {
		input();
		if(pro()) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}
	boolean pro() {
		int index = 0;
		int pp = 0; // pp : a 앞에 오는 p의 갯수
		while(index<str.length()) {
			if(str.charAt(index)=='P') {
				pp++;
			} else if(str.charAt(index)=='A') {
				if(pp<2)
					return false;
				if(index+1<str.length() && str.charAt(index+1)=='P') {
					pp--;
					index++;
				} else {
					return false;
				}
			}
			index++;
		}
		return pp==1;
	}
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class Main {
	public static void main(String[] args) {
		new P16120();
	}
}