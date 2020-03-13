package fractionCalc;

public class slash {
	public static int getIndexOfSlash(String s) {
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '/') {
	            return (i);
	        }
	    }
	    return 0;
	}
	public static boolean isNumber(String s) {
		for(char ch:s.toCharArray()) {
			if(s.charAt(0)=='-') {
			if(Character.isDigit(ch))
				return true;
			else return false;
		} else if(!Character.isDigit(ch)) {
			return false;}		
		}return true;
	}
	public static String beforeSlash(String s) {
		int x=getIndexOfSlash(s);
		String z="";
		if(x>0) {	
		for(int i=x-1;i>=0;i--) {
			z=s.charAt(i)+z;
			
		}
	}return z;
	}
	public static String afterSlash(String s) {
		int x=getIndexOfSlash(s);	
		String z="";
		if(x>0) {	
		for(int i=x+1;i<s.length();i++) {			
			z+=s.charAt(i);
			}
	}return z;
	}

}
