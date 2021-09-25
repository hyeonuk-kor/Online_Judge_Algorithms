package data_structure.LinkedList;
public class SingleLinkedList<T> {
	public Node<T> head = null;
	public class Node<T> {
		T data;
		Node<T> next = null;
		public Node(T data) {
			this.data = data;
		}
	}
	public void addNode(T data) {
		if(head==null) {
			head = new Node<T>(data);
		} else {
			Node<T> node = this.head;
			while(node.next!=null)
				node = node.next;
			node.next = new Node<T>(data);
		}
	}
	public void printAll() {
		if(head!=null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next!=null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
	public void addNodeInside(T data, T isData) {
		Node<T> searchedNode = this.search(isData);
		if(searchedNode == null) {
			this.addNode(data);
		} else {
			Node<T> nextNode = searchedNode.next;
			searchedNode.next = new Node<T>(data);
			searchedNode.next.next = nextNode;
		}
	}
	public Node<T> search(T data) {
		if(this.head==null) {
			return null;
		} else {
			Node<T> node = this.head;
			while(node!=null) {
				if(node.data == data) {
					return node;
				} else {
					node = node.next;
				}
			}
			return null;
		}
	}
	public void delete(T isData) {
		if(this.head==null) {
			return;
		} else {
			Node<T> node = this.head;
			if(node.data==isData) {
				this.head = this.head.next;
			} else {
				while(node.next!=null) {
					if(node.next.data==isData) {
						node.next = node.next.next;
						return;
					}
					node = node.next;
				}
			}
		}
	}
	public static void main(String[] args) {
		SingleLinkedList<Integer> LinkedList = new SingleLinkedList<Integer>();
		LinkedList.addNode(1);
		LinkedList.addNode(2);
		LinkedList.addNode(3);
		LinkedList.addNodeInside(5, 1);
		LinkedList.delete(2);
		LinkedList.printAll();
	}
}
