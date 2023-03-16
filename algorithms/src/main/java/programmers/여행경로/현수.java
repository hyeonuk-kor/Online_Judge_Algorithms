package programmers.여행경로;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 현수 {
    static List<Node> graph[];
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        Set<String> set = new HashSet<>();
        for(int i=0; i<tickets.length; i++){
            for(int j=0; j<tickets[0].length; j++){
                set.add(tickets[i][j]);
            }
        }
        System.out.println(set.toString());
        return answer;
    }

    static class Node implements Comparable<Node>{
        int no;
        String airport;

        public Node(int no, String airport){
            this.no = no;
            this.airport = airport;
        }

        public int compareTo(Node o){
            return airport.compareTo(this.airport);
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }
}