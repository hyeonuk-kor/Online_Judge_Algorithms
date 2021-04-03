package test;

import java.io.*;
import java.util.*;

class test{

	public static void main(String []argh)
	{
		String a = "23";
		String b = "1234".substring(1,3);
		Object c = b;
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a==b);
		System.out.println(a==c);

	}
}
