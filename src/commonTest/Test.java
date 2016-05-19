package commonTest;


public class Test {
	public static void main(String[] args) {
		char[] a = Integer.toBinaryString(7).toCharArray();
		
		for(char x : a){
			System.out.println(x);
		}
	}
}
