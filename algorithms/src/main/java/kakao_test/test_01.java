package kakao_test;

public class test_01 {
	public static void main(String[] args) {
		
		String test = "...";
		
		//1 step
		test = test.toLowerCase();
		
		//2 step
		String[] puncts = {"`","~","!","@","#","$","%","^","&","*","(",")","+","=","\"","|","]","[","}","{","\\","'",":",";","/","?",">","<",","};
		for (String string : puncts) {
			if(test.contains(string))
				test = test.replaceAll("\\"+string, "");
		}
		
		//3 step
		test = test.replaceAll("\\.{2,}",".");
		
		//4 step
		try {
			if(test.charAt(0)=='.')
				test = test.substring(1);
			if(test.charAt(test.length()-1)=='.')
				test = test.substring(0, test.length()-1);
		} catch (Exception e) {
		}

		//5 step
		if(test.length()==0)
			test = test.replace("", "a");
		
		//6 step
		if(test.length()>15) {
			test = test.substring(0, 15);
			try {
				if(test.charAt(0)=='.')
					test = test.substring(1);
				if(test.charAt(test.length()-1)=='.')
					test = test.substring(0, test.length()-1);
			} catch (Exception e) {
			}
		}
		
		
		//7 step
		if(test.length()<3) {
			while(test.length()!=3) {
				test+=test.charAt(test.length()-1);
			}
		}

		System.out.println(test);
	}
}
