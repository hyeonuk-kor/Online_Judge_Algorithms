// 테스트를 위해, inner class 인 Node 클래스를 별도의 클래스로 선언함
public class Node{
    Node left;
    Node right;
    int value;
    Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}