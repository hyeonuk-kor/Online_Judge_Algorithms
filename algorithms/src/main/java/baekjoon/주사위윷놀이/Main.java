package baekjoon.주사위윷놀이;
import java.io.*;
import java.util.*;
class Node {
	Node next, pNext;
	int number;
	boolean check;
	public Node(int number) {
		this.number = number;
	}
	Node addNode(int number) {
		Node node = new Node(number);
		this.next = node;
		return node;
	}
	Node getNode(Node start, int number) {
		Node temp = start;
		while(temp!=null) {
			if(temp.number==number)
				return temp;
			temp = temp.next;
		}
		return null;
	}
}
public class Main {
	static int dice[] = new int[10], order[] = new int[10], answer;
	static Node[] horse = new Node[4];
	static Node start, end;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boardInit();
		for(int i=0; i<10; i++) 
			dice[i] = Integer.parseInt(st.nextToken());
		setHorse(0);
		System.out.println(answer);
	}
	static void setHorse(int index) {
		if(index==10) {
			answer = Math.max(answer, simulation(0));
			return;
		} 
		for(int i=0; i<4; i++) {
			order[index] = i;
			setHorse(index+1);
		}
	}
	static int simulation(int sum) {
		for(int i=0; i<10; i++) {
			Node current = horse[order[i]];
			current.check = false;
			for(int j=0; j<dice[i]; j++) {
				if(j==0 && current.pNext!=null) 
					current = current.pNext;
				else 
					current = current.next;
			}
			horse[order[i]] = current;
			if(current.check && current!=end) {
				sum = 0;
				break;
			} else {
				current.check = true;
				sum += current.number;
			}
		}
		for(int i=0; i<4; i++) {
			horse[i].check = false;
			horse[i] = start;
		}
		return sum;
	}
	static void boardInit() {
		start = new Node(0);
		end = new Node(0);
		end.next = end;
		Node node = start;
		for(int i=2; i<=40; i+=2) node = node.addNode(i);
		node.next = end;
		Node centerJunction = new Node(25);
		Node leftJunction = node.getNode(start, 10);
		leftJunction.pNext = new Node(13);
		leftJunction.pNext.addNode(16).addNode(19).next = centerJunction;
		Node bottomJunction = node.getNode(start, 20);
		bottomJunction.pNext = new Node(22);
		bottomJunction.pNext.addNode(24).next = centerJunction;
		Node rightJunction = node.getNode(start, 30);
		rightJunction.pNext = new Node(28);
		rightJunction.pNext.addNode(27).addNode(26).next = centerJunction;
		centerJunction.addNode(30).addNode(35).next = node.getNode(start, 40);
		Arrays.fill(horse, start);
	}
}
