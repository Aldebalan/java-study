package prob01;

public class Printer {

//	public void println(int i) {
//		System.out.println(i);
//	}
//
//	public void println(boolean b) {
//		System.out.println(b);	
//	}
//	
//	public void println(double d) {
//		System.out.println(d);		
//	}
//	
//	public void println(String s) {
//		System.out.println(s);		
//	}

	// generic method
	// 제네릭(Generic)은 클래스 내부에서 지정하는 것이 아닌
	// 외부에서 사용자에 의해 지정되는 것을 의미한다
//	public <T> void println(T t) {
//		System.out.println(t);
//	}

	// generic & 가변 동시 사용
	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.print(t + " ");
		} 
		System.out.println("");
	}

	// 가변(파라미터) 배열 생성
	public int sum(int... nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		return sum;
	}
}
