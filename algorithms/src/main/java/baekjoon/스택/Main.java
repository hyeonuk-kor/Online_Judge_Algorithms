package baekjoon.스택;
import java.io.*;
import java.util.StringTokenizer;
interface MyStack {
	void push(int number);
	int pop();
	int size();
	boolean isEmpty();
	int top();
}
class Stack implements MyStack {
	private int top;
	private int array[];
	public Stack(int size) {
		this.top = -1;
		this.array = new int[size];
	}
	@Override
	public void push(int number) {
		array[++this.top] = number;
	}
	@Override
	public int pop() {
		if(isEmpty()) return -1;
		return array[this.top--];
	}
	@Override
	public int size() {
		return this.top+1;
	}
	@Override
	public boolean isEmpty() {
		return top == -1;
	}
	@Override
	public int top() {
		if(isEmpty()) return -1;
		return array[this.top];
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Stack s = new Stack(N);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String cmd = st.nextToken();
			switch (cmd) {
			case "push":
				int number = Integer.parseInt(st.nextToken());
				s.push(number);
				break;
			case "pop":
				bw.append(s.pop()+"\n");
				break;
			case "size":
				bw.append(s.size()+"\n");
				break;
			case "empty":
				if(s.isEmpty()) bw.append("1\n");
				else bw.append("0\n");
				break;
			case "top":
				bw.append(s.top()+"\n");
				break;
			}
		}
		bw.flush();
	}
}
