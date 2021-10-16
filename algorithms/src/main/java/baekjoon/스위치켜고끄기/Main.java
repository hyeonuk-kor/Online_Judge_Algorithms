package baekjoon.스위치켜고끄기;
import java.io.*;
import java.util.*;
public class Main {
	static class P1244 {
		class Student {
			int sex;
			int number;
			public Student(int sex, int number) {
				this.sex = sex;
				this.number = number;
			}
		}
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		StringTokenizer st;
		int N; // 스위치 개수
		int button[]; // 스위치의 상태
		int student; // 학생 수
		ArrayList<Student> testcase;
		String solve() {
			input();
			for(Student s: testcase) {
				int sex = s.sex;
				int number = s.number;
				if(sex==1) {
					for(int i=number; i<=N; i+=number)
						button[i] = (button[i]==0)?1:0;
				} else {
					int left = number-1, right = number+1;
					button[number] = (button[number]==0)?1:0;
					while(left>=1 && right<=N) {
						if(button[left]!=button[right])
							break;
						button[left] = (button[left]==0)?1:0;
						button[right] = button[left];
						left--;
						right++;
					}
				}
			}
			int count = 0;
			for(int i=1; i<=N; i++) {
				if(count==20) {
					count = 0;
					sb.append('\n');
				}
				count++;
				sb.append(button[i]).append(' ');
			}
			return sb.toString();
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				button = new int[N+1];
				st = new StringTokenizer(br.readLine());
				for(int i=1; i<=N; i++) {
					button[i] = Integer.parseInt(st.nextToken());
				}
				student = Integer.parseInt(br.readLine());
				testcase = new ArrayList<>();
				for(int i=0; i<student; i++) {
					st = new StringTokenizer(br.readLine());
					int sex = Integer.parseInt(st.nextToken());
					int number = Integer.parseInt(st.nextToken());
					testcase.add(new Student(sex, number));
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P1244().solve());
	}
}
