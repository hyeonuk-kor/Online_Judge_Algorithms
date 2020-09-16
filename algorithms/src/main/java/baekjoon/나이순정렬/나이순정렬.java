package baekjoon.나이순정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	int age;
	String name;
	int date;
	
	public Person(int age, String name, int date) {
		super();
		this.age = age;
		this.name = name;
		this.date = date;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age==o.age)
			return Integer.compare(this.date, o.date);
		return Integer.compare(this.age, o.age);
	}

	@Override
	public String toString() {
		return age + " " + name + "\n";
	}
	
	
}

public class 나이순정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Person> pq = new PriorityQueue<Person>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		
		while(!pq.isEmpty()) {
			bw.write(pq.poll().toString());
		}
		bw.close();
		
	}
}
