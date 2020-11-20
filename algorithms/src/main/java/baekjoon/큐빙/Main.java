package baekjoon.큐빙;

import java.util.Arrays;

public class Main {
	static final int U=0,D=1,F=2,B=3,L=4,R=5;
	static char cube[][][];
	public static void main(String[] args) {
		makeCube();
		rotate('L', '+');
		for(int i=0; i<3; i++)
			System.out.println(Arrays.toString(cube[U][i]));
		rotate('L', '+');
		for(int i=0; i<3; i++)
			System.out.println(Arrays.toString(cube[U][i]));
		rotate('L', '+');
		for(int i=0; i<3; i++)
			System.out.println(Arrays.toString(cube[U][i]));
		rotate('L', '+');
		for(int i=0; i<3; i++)
			System.out.println(Arrays.toString(cube[U][i]));
	}

	static void rotate(char square, char dir) {
		char temp[] = new char[3];
		switch (square) {
		case 'L':
			if(dir=='+') {
				for(int i=0; i<3; i++) {
					temp[i] = cube[B][i][0];
					cube[B][i][0] = cube[U][i][0];
					cube[U][i][0] = cube[F][i][0];
					cube[F][i][0] = cube[D][i][0];
					cube[D][i][0] = temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					temp[i] = cube[D][i][0];
					cube[D][i][0] = cube[F][i][0];
					cube[F][i][0] = cube[U][i][0];
					cube[U][i][0] = cube[B][i][0];
					cube[B][i][0] = temp[i];
				}
			}
			break;
		case 'R':
			if(dir=='+') {

			} else {

			}
			break;
		case 'U':
			if(dir=='+') {

			} else {

			}
			break;
		case 'D':
			if(dir=='+') {

			} else {

			}
			break;
		case 'F':
			if(dir=='+') {

			} else {

			}
			break;
		case 'B':
			if(dir=='+') {

			} else {

			}
			break;
		}
	}

	static void makeCube() {
		char color[] = {'w', 'y', 'r', 'o', 'g', 'b'};
		cube = new char[6][3][3];
		for(int i=0; i<6; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					cube[i][j][k] = color[i];
				}
			}
		}		
	}

}
