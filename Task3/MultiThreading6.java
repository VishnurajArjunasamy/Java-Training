package Task3;


class CharacterCounter {
	int counter;
 	void charCounter(char c) {
 		try {
 			if(Character.isDigit(c)) {
 				throw new Exception();
 			}
 			counter++;
 		}
 		catch(Exception e) {
 			e.printStackTrace();
 		}
	}
}

public class MultiThreading6 {
	public static void main(String[] args) {
		CharacterCounter cc = new CharacterCounter();
		String s = "qwe6rty";
		
		for(int i=0;i<s.length();i++) {
			cc.charCounter(s.charAt(i));
		}
	
		System.out.println(cc.counter);
	}
}
