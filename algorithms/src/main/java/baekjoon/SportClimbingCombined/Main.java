package baekjoon.SportClimbingCombined;
import java.io.*;
import java.util.*;
public class Main {
	static class P23246 {
		StringBuilder sb = new StringBuilder();
		static class Player {
			int number, order[];
			int sum, score;
			Player() {
				order = new int[3];
				score = 1;
			}
			void calc() {
				for(int i=0; i<3; i++) {
					score *= order[i];
					sum += order[i];
				}
			}
			public int getNumber() {
				return number;
			}
			public int getSum() {
				return sum;
			}
			public int getScore() {
				return score;
			}
		}
		int N;
		Player p[];
		String Solve() {
			input();
			Comparator<Player> o1 = Comparator.comparing(Player::getScore);
			Comparator<Player> o2 = Comparator.comparing(Player::getSum);
			Comparator<Player> o3 = Comparator.comparing(Player::getNumber);			
			Arrays.sort(p, o1.thenComparing(o2).thenComparing(o3));
			for(int i=0; i<3; i++)
				sb.append(p[i].getNumber()).append(' ');
			return sb.toString();
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				p = new Player[N];
				for(int i=0; i<N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					p[i] = new Player();
					p[i].number = Integer.parseInt(st.nextToken());
					for(int j=0; j<3; j++)
						p[i].order[j] = Integer.parseInt(st.nextToken());
					p[i].calc();
				}
			} catch (Exception e) {
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P23246().Solve());
	}
}