package baekjoon.국영수;
import java.io.*;
import java.util.*;
class P10825 {
	class Student implements Comparable<Student>{
		private String name;
		private int kor, eng, math;
		@Override
		public int compareTo(Student o) {
			int ret = o.kor - this.kor;
			if(ret==0) ret = this.eng - o.eng;
			if(ret==0) ret = o.math - this.math;
			if(ret==0) ret = this.name.compareTo(o.name);
			return ret;
		}
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	public void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		PriorityQueue<Student> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			pq.add(new Student(name, kor, eng, math));
		}
		while(!pq.isEmpty())
			pw.println(pq.poll().name);
		pw.flush();
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		new P10825().solve();
	}
}
