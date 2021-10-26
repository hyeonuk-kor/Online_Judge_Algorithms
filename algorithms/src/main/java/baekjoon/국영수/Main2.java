package baekjoon.국영수;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P10825 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N;
		ArrayList<Student> student = new ArrayList<>();
		class Student { // 학생 클래스
			private String name;
			private int kor, eng, math;
			public Student(String name, int kor, int eng, int math) {
				this.name = name;
				this.kor = kor;
				this.eng = eng;
				this.math = math;
			}
			public String getName() {
				return name;
			}
			public int getKor() {
				return kor;
			}
			public int getEng() {
				return eng;
			}
			public int getMath() {
				return math;
			}
		}
		void solve() {
			input();
			sb = new StringBuilder();
			Comparator<Student> kor = Comparator.comparing(Student::getKor).reversed();   // 국어 점수 감소하는 순
			Comparator<Student> eng = Comparator.comparing(Student::getEng);			     // 영어 점수 증가하는 순
			Comparator<Student> math = Comparator.comparing(Student::getMath).reversed(); // 수학 점수 감소하는 순
			Comparator<Student> name = Comparator.comparing(Student::getName);			 // 이름이 증가하는 순
			Comparator<Student> p10825_sort = kor.thenComparing(eng).thenComparing(math).thenComparing(name);
			Collections.sort(student, p10825_sort);
			for(Student s: student)
				sb.append(s.getName()).append("\n");
			System.out.println(sb);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				N = Integer.parseInt(br.readLine());
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					String name = st.nextToken();
					int kor = Integer.parseInt(st.nextToken());
					int eng = Integer.parseInt(st.nextToken());
					int math = Integer.parseInt(st.nextToken());
					student.add(new Student(name, kor, eng, math));
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10825().solve();
	}
}