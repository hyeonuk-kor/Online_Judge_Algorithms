package baekjoon.택시기하학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class 택시기하학 {
	
	public static void main(String[] args) throws Exception {
		int R = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()); 
		System.out.println(Math.PI*Math.pow(R, 2));
		System.out.println(2*Math.pow(R, 2));
	}
	
}
