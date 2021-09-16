package baekjoon.RBY팡;
import java.io.*;
public class Main {
	static int N, ball[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ball = new int[N];
		for(int i=0; i<N; i++)
			ball[i] = Integer.parseInt(br.readLine());
		int answer = N;
		for(int i=0; i<N; i++) {
			int count = changeBall(i);
			answer = Math.min(count, answer);
		}
		System.out.println(answer);
	}
	static int changeBall(int index) {
		int color = ball[index];
		int result1=N, result2=N;
		ball[index] = selectBall(color-1);
		result1 = pang(index, index, N);
		ball[index] = selectBall(color+1);
		result2 = pang(index, index, N);
		ball[index] = color;
		return Math.min(result1, result2);
	}
	static int selectBall(int number) {
		if(number==4)
			return 1;
		else if(number==0)
			return 3;
		else
			return number;
	}
	static int pang(int up, int down, int size) {
		int up_block = 1, down_block = 1;
		int next_up = up, next_down = down;
		while(next_up-1>=0 && ball[next_up]==ball[next_up-1]) {
			next_up--;
			up_block++;
		}
		while(next_down+1<N && ball[next_down]==ball[next_down+1]) {
			next_down++;
			down_block++;
		}
		int block=0;
		if(up>=0 && up<N && down>=0 && down<N) {
			if(ball[up]==ball[down]) {
				block = up_block + down_block -(up==down?1:0);
				if(block>=4)
					size = pang(next_up-1, next_down+1, size-block);
			}
		} 
		return size;
	}
}