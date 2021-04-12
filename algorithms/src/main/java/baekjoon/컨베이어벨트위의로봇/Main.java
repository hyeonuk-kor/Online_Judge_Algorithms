package baekjoon.컨베이어벨트위의로봇;
import java.util.*;
import java.io.*;
public class Main {
	static int N, K;
	static ArrayList<Integer> belt = new ArrayList<Integer>();
	static ArrayList<Boolean> robot = new ArrayList<Boolean>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++)
			belt.add(Integer.valueOf(st.nextToken()));
		for(int i=0; i<N; i++)
			robot.add(false);
		System.out.println(simulate());
	}
	static int simulate() {
		int step = 0;
		while(zeroCount()<K) {
			Collections.rotate(belt, 1);
			Collections.rotate(robot, 1);
			robot.set(0, false);
			robot.set(N-1, false);
			for(int i=N-1; i>0; i--) {
				if(robot.get(i-1) && !robot.get(i) && belt.get(i)>=1) {
					Collections.swap(robot, i, i-1);
					belt.set(i, belt.get(i)-1);
				}
			}
			if(belt.get(0)>0) {
				robot.set(0, true);
				belt.set(0, belt.get(0)-1);
			}
			step++;
		}
		return step;
	}
	static int zeroCount() {
		int count = 0;
		for(int i=0; i<belt.size(); i++) {
			if(belt.get(i)==0)
				count++;
		}
		return count;
	}
}