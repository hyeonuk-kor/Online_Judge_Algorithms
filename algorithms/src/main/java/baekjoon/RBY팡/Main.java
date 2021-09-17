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
		ball[index] = selectBall(color-1);
		int result1 = pang(index, index, N);
		ball[index] = selectBall(color+1);
		int result2 = pang(index, index, N);
		ball[index] = color;
		return Math.min(result1, result2);
	}
	static int selectBall(int number) {
		if(number==0)
			return 3;
		else if(number==4)
			return 1;
		else
			return number;
	}
	static int pang(int left, int right, int size) {
		if(size<4 || left<0 || right<0 || left>=N || right>=N || ball[left]!=ball[right])
			return size;
		int l = left, r = right;
		int left_count = 1, right_count = 1;
		while(l-1>=0 && ball[l]==ball[l-1]) {
			left_count++;
			l--;
		}
		while(r+1<N && ball[r]==ball[r+1]) {
			right_count++;
			r++;
		}
		int score = left_count+right_count-(left==right?1:0);
		if(score>=4)
			size = pang(l-1, r+1, size-score);
		return size;
	}
}