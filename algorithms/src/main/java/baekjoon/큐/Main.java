package baekjoon.큐;
import java.io.*;
import java.util.StringTokenizer;
interface MyQueue {
	void push(int number);
	int pop();
	int size();
	boolean isEmpty();
	int front();
	int back();
}
class Queue implements MyQueue {
	private int front;
	private int back;
	private int array[];
	public Queue(int size) {
		this.front =0;
		this.back = 0;
		this.array = new int[size];
	}
	@Override
	public void push(int number) {
		array[this.back++] = number;
	}
	@Override
	public int pop() {
		if(isEmpty()) return -1;
		return array[this.front++];
	}
	@Override
	public int size() {
		return this.back-this.front;
	}
	@Override
	public boolean isEmpty() {
		return this.front == this.back;
	}
	@Override
	public int front() {
		if(isEmpty()) return -1;
		return array[this.front];
	}
	@Override
	public int back() {
		if(isEmpty()) return -1;
		return array[this.back-1];
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Queue s = new Queue(N);
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
			case "front":
				bw.append(s.front()+"\n");
				break;
			case "back":
				bw.append(s.back()+"\n");
				break;
			}
		}

		bw.flush();
	}
}
