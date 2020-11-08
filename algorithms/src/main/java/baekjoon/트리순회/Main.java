package baekjoon.트리순회;

import java.io.*;
import java.util.*;

class Node {
	private Node left;
	private String name;
	private Node right;

	Node(Node left, String name, Node right) {
		this.left = left;
		this.name = name;
		this.right = right;
	}

	Node getLeft() {
		return left;
	}

	String getName() {
		return name;
	}

	Node getRight() {
		return right;
	}

}

class Tree {
	Node makeTree(Node left, Node parent, Node right) {
		Node node = new Node(left, parent.getName(), right);
		return node;
	}

	void preorderTraversal(Node node) {
		if(node!=null) {
			System.out.print(node.getName()+" ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}

	void inorderTraversal(Node node) {
		if(node!=null) {
			preorderTraversal(node.getLeft());
			System.out.print(node.getName()+" ");
			preorderTraversal(node.getRight());
		}
	}

	void postorderTraversal(Node node) {
		if(node!=null) {
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
			System.out.print(node.getName()+" ");
		}
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Tree t = new Tree();
		Node[] a = new Node[26];
		for(char i='A'; i<='Z'; i++) {
			a[i-'A'] = new Node(null, i+"", null);
		}
		int N = Integer.parseInt(br.readLine());
		Node root = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String p = st.nextToken();
			String l = st.nextToken();
			String r = st.nextToken();
			Node parent = a[p.charAt(0)-'A'];
			Node right, left;
			if(l.equals(".")) left = null;
			else left = a[l.charAt(0)-'A'];
			
			if(r.equals(".")) right = null;
			else right = a[r.charAt(0)-'A'];
			
			parent = t.makeTree(left, parent, right);
			if(i==0) root = parent;
		}

		t.preorderTraversal(root);
		System.out.println();
		t.inorderTraversal(root);
		System.out.println();
		t.postorderTraversal(root);


	}

}
