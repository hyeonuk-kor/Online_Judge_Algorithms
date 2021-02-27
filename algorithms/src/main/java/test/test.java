package test;

import java.io.*;
import java.util.*;

class test{

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			Stack<Character> s = new Stack<>();
			String input=sc.next();
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)=='(' || input.charAt(i)=='[' || input.charAt(i)=='{'){
					s.push(input.charAt(i));
				} else {
					switch (s.peek()) {
					case '(':
						if(input.charAt(i)==')')
							s.pop();
						break;
					case '[':
						if(input.charAt(i)==']')
							s.pop();
						break;
					case '{':
						if(input.charAt(i)=='}')
							s.pop();
						break;
					}
				}
			}
			if(!s.isEmpty())
				System.out.println("false");
			else
				System.out.println("true");
			s.clear();
		}

	}
}
