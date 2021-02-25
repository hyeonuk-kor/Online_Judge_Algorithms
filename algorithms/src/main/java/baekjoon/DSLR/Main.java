package baekjoon.DSLR;
import java.io.*;
import java.util.*;
class Register {
	private int num;
	private String command;
	public Register(int num, String command) {
		this.num = num;
		this.command = command;
	}
	public int getNum() {
		return num;
	}
	public String getCommand() {
		return command;
	}
	public int transNumber(int cmd) {
		int calc = 0;
		switch (cmd) {
			case 0:
				calc = (num*2);
				calc %= 10000;
				break;
			case 1:
				calc = num-1;
				if(calc<0)
					calc = 9999;
				break;
			case 2:
				//1234
				calc = (num%1000)*10; // 2340
				calc += num/1000;	  // 2341
				break;
			case 3:
				//1234: 
				calc = (num%10)*1000; //4000
				calc += num/10;		  //4123
				break;
		}
		return calc;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.valueOf(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			boolean number[] = new boolean[10000];
			Queue<Register> q = new ArrayDeque<>();
			q.add(new Register(A, ""));
			number[A] = true;
			while(!q.isEmpty()) {
				Register r = q.poll();
				if(r.getNum()==B) {
					bw.append(r.getCommand()+"\n");
					break;
				}
				for(int d=0; d<4; d++) {
					int tnum = r.transNumber(d);
					if(!number[tnum]) {
						q.add(new Register(tnum, r.getCommand()+getCmd(d)));
						number[tnum] = true;
					}
				}
			}
		}
		bw.flush();
	}
	static String getCmd(int d) {
		if(d==0) {
			return "D";
		} else if(d==1) {
			return "S";
		} else if(d==2) {
			return "L";
		} else {
			return "R";
		}
	}
}