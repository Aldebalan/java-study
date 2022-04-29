package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");

		// 두 객체는 다르다
		System.out.println(s1 == s2);
		// 두 객체의 내용은 같다
		System.out.println(s1.equals(s2));
		// 두 객체의 내용기반 해시코드는 같다
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		// 두 객체의 주소기반 해시코드는 다르다
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));

		System.out.println("===================");
		
		// 동일한 객체이다.
		// String은 불변 객체, 내부를 바꿀 수 없다
		// 바꾸려면 다른 메소드를 써야한다
		String s3 = "hello";
		String s4 = "hello";

		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
		
		
	}

}
