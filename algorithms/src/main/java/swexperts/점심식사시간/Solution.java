package swexperts.점심식사시간;
import java.io.*;
import java.util.*;
class Node {
	int y, x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Solution {
	static int n, map[][], pickStair[], answer;
	static ArrayList<Node> people, stair;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.valueOf(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			n = Integer.valueOf(br.readLine());
			map = new int[n][n];
			people = new ArrayList<Node>();
			stair = new ArrayList<Node>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
					if(map[i][j]==1) {
						people.add(new Node(i, j));
					} else if(map[i][j]>=2) {
						stair.add(new Node(i, j));
					}
				}
			}
			pickStair = new int[people.size()];
			simulate(0);
			pw.println("#"+tc+" "+answer);
		}
		pw.flush();
	}
	static void simulate(int peopleIndex) {
		if(peopleIndex==people.size()) {
			calcTime();
			return;
		}
		for(int stairIndex=0; stairIndex<2; stairIndex++) {
			pickStair[peopleIndex] = stairIndex;
			simulate(peopleIndex+1);
		}
	}
	static void calcTime() {
		int calcTime = 0;
		for(int stairIndex=0; stairIndex<2; stairIndex++) {
			Node nowStair = stair.get(stairIndex);
			int arrivalTime[] = new int[n*2+1];
			int getCountStepPeople[] = new int[arrivalTime.length+10];
			for(int peopleIndex=0; peopleIndex<people.size(); peopleIndex++) {
				if(pickStair[peopleIndex]==stairIndex) {
					arrivalTime[getDistance(people.get(peopleIndex), nowStair)+1]++;
				}
			}
			int getMinTime = 0;
			for(int time=1; time<=n*2; time++) {
				while(arrivalTime[time]>0) {
					arrivalTime[time]--;
					int calcStepTime = map[nowStair.y][nowStair.x];
					for(int walkTime=time; walkTime<getCountStepPeople.length; walkTime++) {
						if(getCountStepPeople[walkTime]<3) {
							getCountStepPeople[walkTime]++;
							calcStepTime--;
							if(calcStepTime==0) {
								getMinTime = Math.max(getMinTime, walkTime+1);
								break;
							}
						}
					}
				}
			}
			calcTime = Math.max(calcTime, getMinTime);
		}
		answer = Math.min(answer, calcTime);
	}
	static int getDistance(Node p, Node s) {
		int dx = Math.abs(p.x - s.x);
		int dy = Math.abs(p.y - s.y);
		return dx + dy;
	}
}