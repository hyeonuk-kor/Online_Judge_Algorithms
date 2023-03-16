package baekjoon;
import java.io.*;

public class test {
    
    static int i;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int i;
        for(i=0; i<=3; i++) {
        	int j;
        	for( j=i; j<10+i; j++) 
        		System.out.print(j);
        	
        	System.out.println("");
        }
    }
    

    
}