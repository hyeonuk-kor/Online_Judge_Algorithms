package baekjoon.단어의개수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 단어의개수 {
	public static void main(String[] args) throws IOException {
		System.out.println(new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()).countTokens());
	}
}
