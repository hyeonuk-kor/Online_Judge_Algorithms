package baekjoon.큐2;
import java.io.*;
import java.util.*;
interface MyQueue {
	void push(int number);
	int pop();
	int size();
	boolean isEmpty();
	int front();
	int back();
}
class Queue<Integer> implements MyQueue {
	private Node<Integer> front;
	private Node<Integer> back;
	private int size = 0;
	class Node<Integer> {
		private Integer data;
		private Node<Integer> next;
		Node(Integer data) {
			this.data = data;
		}
	}
	@Override
	public void push(int number) {
		Node<Integer> t = new Node(number);
		if(back!=null) 
			back.next = t;
		back = t;
		if(front==null) 
			front = back;
		this.size++;
	}
	@Override
	public int pop() {
		if(isEmpty()) return -1;
		this.size--;
		Integer number = front.data;
		front = front.next;
		return (int) number;
	}
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public boolean isEmpty() {
		return front==null;
	}
	@Override
	public int front() {
		if(isEmpty()) return -1;
		return (int)front.data;
	}
	@Override
	public int back() {
		if(isEmpty()) return -1;
		return (int)back.data;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> s = new Queue<>();
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