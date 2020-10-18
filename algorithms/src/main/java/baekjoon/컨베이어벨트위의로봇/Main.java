package baekjoon.컨베이어벨트위의로봇;

import java.util.*;
import java.io.*;

public class Main {

	static int N, K, A[][], robot[][];
	static int upIndex, downIndex, robot_number;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[2][N];
		robot = new int[2][N];

		upIndex = 0;
		downIndex = (2*N-1)/2;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			if(i<=downIndex) {
				A[0][i]= Integer.parseInt(st.nextToken());
			} else {
				A[1][2*N-i-1]= Integer.parseInt(st.nextToken());
			}
		}

		int answer = 1;
		robot_number=1;
		while(true) {
			System.out.println("벨트 한칸 회전");
			rotateBelt();
			System.out.println(Arrays.toString(A[0]));
			System.out.println(Arrays.toString(A[1]));
			System.out.println("벨트에 있던 로봇이 따라옴");
			rotateRobot();
			System.out.println(Arrays.toString(robot[0]));
			System.out.println(Arrays.toString(robot[1]));
			System.out.println("먼저 들어간 로보트 움직이기");
			if(answer!=1) moveRobot(); //최초에는 로봇이 없다.
			System.out.println();
			if(robot[upIndex][0]==0) {
				System.out.println("로봇 추가");
				robot[upIndex][0] = robot_number++;
				System.out.println(Arrays.toString(robot[0]));
				System.out.println(Arrays.toString(robot[1]));
				A[upIndex][0]--;
			}
			if(check()) break;
			answer++;
		}
		System.out.println(answer);
	}

	static boolean check() {
		int cnt=0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<N; j++) {
				if(A[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt>=K) return true;
		return false;
	}

	static void moveRobot() {
		loop:for(int n=1; n<robot_number; n++) {
			int downTemp = robot[0][N-1];
			for(int i=N-1; i>=1; i--) {
				if(robot[0][i-1]==n && robot[0][i]==0 && A[0][i]>=1) {
					robot[0][i] = n; robot[0][i-1]=0; A[0][i]--;
					continue loop;
				}
			}
			if(robot[1][0]==n && robot[0][0]==0 && A[0][0]>=1) {
				robot[0][0] = n; robot[1][0]=0; A[0][0]--;
				continue loop;
			}
			for(int i=0; i<N-1; i++) {
				if(robot[1][i+1]==n && robot[1][i]==0 && A[1][i]>=1) {
					robot[1][i] = n; robot[1][i+1]=0; A[1][i]--;
					continue loop;
				}
			}
			if(downTemp==n && robot[1][N-1]==0 && A[0][N-1]>=1) {
				robot[1][N-1] = n;
				A[0][N-1]--;
			}
		}
	}

	static void rotateRobot() {
		int downTemp = robot[0][N-1];
		for(int i=N-1; i>=1; i--) robot[0][i] = robot[0][i-1]; //right 
		robot[0][0] = robot[1][0]; //up
		for(int i=0; i<N-1; i++) robot[1][i] = robot[1][i+1]; //left
		robot[1][N-1] = downTemp; //down
	}

	static void rotateBelt() {
		int downTemp = A[0][N-1];
		for(int i=N-1; i>=1; i--) A[0][i] = A[0][i-1]; //right 
		A[0][0] = A[1][0]; //up
		for(int i=0; i<N-1; i++) A[1][i] = A[1][i+1]; //left
		A[1][N-1] = downTemp; //down
	}

}
