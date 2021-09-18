package test;
import java.util.*;
class Student{
    public int x;
    public int y;
    public Student(int x, int y){
        this.x=x;
        this.y=y;
    }
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

public class Main {
    public static String addZero(String num){
        String temp="";
        temp+="0";
        temp+=num;
        return temp;
    }
    public static void main(String[] args) throws Exception {
    	Comparator<Student> asc = Comparator.comparing(Student::getX);
    	Comparator<Student> desc = Comparator.comparing(Student::getY).reversed();
        TreeMap<Student, String> test= new TreeMap<Student, String>(asc.thenComparing(desc));
        Student a = new Student(1, 3);
        Student b = new Student(1, 2);
        Student c = new Student(1, 1);
        Student d = new Student(2, 3);
        Student e = new Student(2, 2);
        Student f = new Student(2, 1);
        Student g = new Student(3, 3);
        Student h = new Student(3, 2);
        Student i = new Student(3, 1);
        test.put(a, "hi");
        test.put(c, "lo");
        test.put(d, "ho");
        test.put(b, "bye");
        test.put(f, "t");
        test.put(h, "tdo");
        test.put(g, "lao");
        test.put(e, "go");
        test.put(i, "tto");
        for(var s: test.entrySet())
        	System.out.println(s);
    }
}
