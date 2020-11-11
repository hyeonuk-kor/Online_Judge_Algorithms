package baekjoon.팰린드롬수;
import java.util.*;
import java.io.*;
public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		
		while(!input.equals("0")) {
			List<Character> list = new LinkedList<>();
			ListIterator<Character> right = list.listIterator();
			int len = input.length();

			for(int i=0; i<len; i++) {
				right.add(input.charAt(i));
			}

			ListIterator<Character> left = list.listIterator();

			boolean check = true;
			len/=2;
			while(len-->0) {
				if(left.next()==right.previous()) {
					continue;
				} else {
					check = false;
					break;
				}
			}
			if(check) {
				bw.append("yes\n");
			} else {
				bw.append("no\n");
			}
			input = br.readLine();
		}

		bw.flush();
	}
}
