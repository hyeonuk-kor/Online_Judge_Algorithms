package baekjoon.신나는함수실행;
import java.io.*;
import java.util.*;
public class Main {
	static HashMap<String, Integer> w = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1 && c==-1)
				break;
			bw.append(getKey(a,b,c)+getW(a, b, c)+"\n");
		}
		bw.flush();
	}
	static int getW(int a, int b, int c) {
		String key = getKey(a,b,c);
		if(!w.containsKey(key)) {
			if(a<=0 || b<=0 || c<=0) {
				w.put(key, 1);
			} else if(a>20 || b>20 || c>20) { 
				w.put(key, getW(20, 20, 20));
			} else if(a<b && b<c) {
				w.put(key, getW(a, b, c-1) + getW(a, b-1, c-1) - getW(a, b-1, c));
			} else {
				w.put(key, getW(a-1, b, c) + getW(a-1, b-1, c) + getW(a-1, b, c-1) - getW(a-1, b-1, c-1));
			}
		}
		return w.get(key);
	}
	static String getKey(int a, int b, int c) {
		return "w("+a+", "+b+", "+c+") = ";
	}
}
