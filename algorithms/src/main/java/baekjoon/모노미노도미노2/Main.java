package baekjoon.모노미노도미노2;
import java.io.*;
import java.util.*;
public class Main {
	static LinkedList<ArrayList<Boolean>> green, blue;
	static int score;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		green = new LinkedList<ArrayList<Boolean>>();
		blue = new LinkedList<ArrayList<Boolean>>();
		for(int i=0; i<6; i++) {
			green.add(emptyArray());
			blue.add(emptyArray());
		}
		int N = Integer.valueOf(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			dropBlock(green, t, x, y);
			dropBlock(blue, (t==2 ? 3: t==3 ? 2 : t), y, x);
			getScore(green);
			getScore(blue);
			checkZeroOne(green);
			checkZeroOne(blue);
		}
		System.out.println(score+"\n"+countBlock());
	}
	static void getScore(LinkedList<ArrayList<Boolean>> board) {
		int idx = board.size()-1;
		while(idx!=1) {
			if(!board.get(idx).contains(false)) {
				board.remove(idx);
				board.addFirst(emptyArray());
				score++;
			} else {
				idx--;
			}
		}
	}
	static ArrayList<Boolean> emptyArray() {
		ArrayList<Boolean> temp = new ArrayList<Boolean>();
		for(int j=0; j<4; j++) 
			temp.add(false);
		return temp;
	}
	static void checkZeroOne(List<ArrayList<Boolean>> board) {
		for(int i=0; i<2; i++) {
			if(board.get(1).contains(true)) {
				for(int j=4; j>=0; j--) 
					board.set(j+1, board.get(j));
				board.set(0, emptyArray());
			}
		}
	}
	static void dropBlock(List<ArrayList<Boolean>> board, int t, int x, int y) {
		int fx = board.size()-1;
		if(t==1) {
			for(int i=2; i<=fx; i++) {
				if(board.get(i).get(y)) {
					fx = i-1;
					break;
				}
			}
			board.get(fx).set(y, true);
		} else if(t==2) {
			for(int i=2; i<=fx; i++) {
				if(board.get(i).get(y) || board.get(i).get(y+1)) {
					fx = i-1;
					break;
				}
			}
			board.get(fx).set(y, true);
			board.get(fx).set(y+1, true);
		} else if(t==3) {
			for(int i=2; i<=fx; i++) {
				if(board.get(i).get(y)) {
					fx = i-1;
					break;
				}
			}
			board.get(fx).set(y, true);
			board.get(fx-1).set(y, true);
		}
	}
	static int countBlock() {
		int count = 0;
		for(int i=2; i<6; i++) {
			for(int j=0; j<4; j++) {
				if(green.get(i).get(j))
					count++;
				if(blue.get(i).get(j))
					count++;
			}
		}
		return count;
	}
}