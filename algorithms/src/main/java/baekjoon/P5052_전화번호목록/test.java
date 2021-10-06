package baekjoon.P5052_전화번호목록;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class test {
    public static class Node{
        private Map<Character, Node> childNodes = new HashMap<>();
        private boolean isLast;
    }
    public static class Trie{
        private Node root;
        Trie(){
            this.root = new Node();
        }
        boolean insert(String number){
            Node node = this.root;
            for(int i=0; i<number.length(); i++){
                if(node.isLast && i<number.length()-1) return false; // 숫자를 넣는 중에 last로 체크된 노드를 만나면 현재 번호의 접두어가 다른 번호인 것이므로 false 반환
                node = node.childNodes.computeIfAbsent(number.charAt(i), c -> new Node()); // 자식 노드로
            }
            if(!node.childNodes.isEmpty()) return false; // 번호의 마지막 숫자 노드가 자식을 가지고 있으면 현재 번호가 다른 번호의 접두어가 되므로 false 반환
            node.isLast = true;
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            Trie trie = new Trie();
            for(int j=0; j<n; j++){
            	if(!flag) {
                	br.readLine();
                	continue;
            	}
                // 입력으로 들어온 번호들을 트라이에 넣어준다. 만일 문제에서 말하는 일관성이 없는 경우가 되면 false 반환 
                if(!trie.insert(br.readLine())){ 
                    flag = false;
                }
            }
            if(flag) bw.write("YES\n"); 
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}