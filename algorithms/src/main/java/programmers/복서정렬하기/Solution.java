package programmers.복서정렬하기;
import java.util.*;
public class Solution {
	static class Player {
		int index, win_heavy, weight;
		double win_rate;
		public Player(int index, double win_rate, int win_heavy, int weight) {
			this.index = index;
			this.win_rate = win_rate;
			this.win_heavy = win_heavy;
			this.weight = weight;
		}
		public int getIndex() {
			return index;
		}
		public int getWin_heavy() {
			return win_heavy;
		}
		public int getWeight() {
			return weight;
		}
		public double getWin_rate() {
			return win_rate;
		}
		
	}
	public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Player> list = new ArrayList<>();
        for(int i=0; i<weights.length; i++) {
        	int win_count=0, win_heavy=0;
        	double win_rate=0, game_count=0;
        	for(int j=0; j<head2head[i].length(); j++) {
        		if(i==j) continue;
        		if(head2head[i].charAt(j)!='N')
        			game_count++;
        		if(head2head[i].charAt(j)=='W') {
        			win_count++;
        			if(weights[i]<weights[j])
        				win_heavy++;
        		}
        	}
        	if(game_count!=0)
        		win_rate = win_count/game_count;
        	list.add(new Player(i+1, win_rate, win_heavy, weights[i]));
        }
        list.sort(Comparator.comparing(Player::getWin_rate).thenComparing(Player::getWin_heavy).thenComparing(Player::getWeight).thenComparing(Player::getIndex).reversed());
        for(int i=0; i<list.size(); i++) {
        	answer[i] =list.get(i).getIndex();
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {50, 82, 75, 120}, 
													new String[] {"NLWL","WNLL","LWNW","WWLN"})));
	}
}
