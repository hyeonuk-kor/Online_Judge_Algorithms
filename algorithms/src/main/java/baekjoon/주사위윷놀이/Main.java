package baekjoon.주사위윷놀이;
import java.io.*;
import java.util.*;
class Node {
	Node next, specialPoint;
	int number;
	boolean isCombine;
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
	static Node[] coin = new Node[4];
	static Node start, end;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		mapInit();
		for(int i=0; i<10; i++) 
			dice[i] = Integer.parseInt(st.nextToken());
		setYut(0);
		System.out.println(answer);
	}
	static void setYut(int index) {
		if(index==10) {
			answer = Math.max(answer, simulation(0));
			return;
		} 
		for(int i=0; i<4; i++) {
			order[index] = i;
			setYut(index+1);
		}
	}
	static int simulation(int sum) {
		for(int i=0; i<10; i++) {
			Node current = coin[order[i]];
			current.isCombine = false;
			for(int j=0; j<dice[i]; j++) {
				if(j==0 && current.specialPoint!=null) 
					current = current.specialPoint;
				else 
					current = current.next;
			}
			coin[order[i]] = current;
			if(current.isCombine && current!=end) {
				sum = 0;
				break;
			} else {
				current.isCombine = true;
				sum += current.number;
			}
		}
		for(int i=0; i<4; i++) {
			coin[i].isCombine = false;
			coin[i] = start;
		}
		return sum;
	}
	static void mapInit() {
		start = new Node(0);
		end = new Node(0);
		end.next = end;
		Node node = start;
		for(int i=2; i<=40; i+=2) 
			node = node.addNode(i);
		node.next = end;
		
		Node center = new Node(25);
		
		Node leftSP = node.getNode(start, 10);
		leftSP.specialPoint = new Node(13);
		leftSP.specialPoint.addNode(16).addNode(19).next = center;
		
		Node bottomSP = node.getNode(start, 20);
		bottomSP.specialPoint = new Node(22);
		bottomSP.specialPoint.addNode(24).next = center;
		
		Node rightSP = node.getNode(start, 30);
		rightSP.specialPoint = new Node(28);
		rightSP.specialPoint.addNode(27).addNode(26).next = center;
		
		center.addNode(30).addNode(35).next = node.getNode(start, 40);
		
		Arrays.fill(coin, start);
	}
}
