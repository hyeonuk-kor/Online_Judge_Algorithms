package test.SV;

import java.util.*;

public class P2 {
	static class Student {
		int number;
		String name;
		int grade;
		double dis;
		public Student(int number, String name, int grade, double dis) {
			this.number = number;
			this.name = name;
			this.grade = grade;
			this.dis = dis;
		}
		public int getNumber() {
			return number;
		}
		public String getName() {
			return name;
		}
		public int getGrade() {
			return grade;
		}
		public double getDis() {
			return dis;
		}
	}
	static int[] solution(String[] names, int[][] homes, double[] grades) {
		int length = names.length;
		List<Student> list = new ArrayList<>();
		for(int i=0; i<length; i++) {
			int number = i;
			String name = names[i];
			int grade = (int)grades[i];
			double dis = Math.pow(0-homes[i][0], 2) + Math.pow(0-homes[i][1], 2);
			list.add(new Student(number, name, grade, dis));
		}
		Comparator<Student> order1 = Comparator.comparing(Student::getGrade).reversed();
		Comparator<Student> order2 = Comparator.comparing(Student::getDis).reversed();
		Comparator<Student> order3 = Comparator.comparing(Student::getName);
		Comparator<Student> solution_order = order1.thenComparing(order2).thenComparing(order3);
		Collections.sort(list, solution_order);
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[list.get(i).getNumber()] = i+1;
		}
		return answer;
	}
	public static void main(String[] args) {
		String[] names = {"azad", "andy", "louis", "will", "edward"};
		int[][] homes = {{3, 4}, {-1, 5}, {-4, 4}, {3, 4}, {-5, 0}};
		double[] grades = {4.19, 3.77, 4.41, 3.65, 3.58};
		System.out.println(Arrays.toString(solution(names, homes, grades)));
	}
}
