package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		
		// String method들...
		String s1 = "aBcABCabcAbc";
		// 길이 출력
		System.out.println(s1.length());
		// 인덱스 주소로 지정
		System.out.println(s1.charAt(2));
		// 검색 - 중복이 있을경우 앞에서 부터 하나만 찾아줌
		System.out.println(s1.indexOf("abc"));
		// 검색 - 범위지정 7 이후
		System.out.println(s1.indexOf("abc", 7));
		// 앞을 자름
		System.out.println(s1.substring(3));
		// 범위 자르기
		System.out.println(s1.substring(3,5));
		
		String s2 = "  ab  cd  ";
		String s3 = "efg,hij,klm,nop,qrs";
		
		// 배열 붙이기
		String s4 = s2.concat(s3);
		System.out.println(s4);
		// 양쪽 공백 없애기
		System.out.println("---" + s2.trim() + "---");
		// 치환 - 공백치환
		System.out.println("---" + s2.replaceAll(" ","") + "---");
		// 기준 잡고 분리
		String[] tokens1 = s3.split(",");
		for(String s : tokens1) {
			System.out.println(s);
		}
		// ??
		String[] tokens2 = s3.split(" ");
		for(String s : tokens2) {
			System.out.println(s);
		}
		// + : String concat(연결) 연산자
		// String s5 = "Hello" + "World" + "Java" + "1.8";
		String s5 = new StringBuffer("Hello")
			.append("World")
			.append("Java")
			.append(1.8).toString();
		System.out.println(s5);
		
		// 반복문 작성시 안에 들어갈 메소드 주의
		String s6 = "";
		for(int i = 0; i < 1000000; i++) {
			//s6 = s6 + i;
			// new 라는 메소드를 for 문에 넣으면 CPU 할당에 좋지않음
			// s6 = new StringBuffer(s6).append(i).toString();
		}
		
		StringBuffer sb6 = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			sb6.append(i);
		}
		String s7 = sb6.toString();
		System.out.println(s7.length());
		
	}

}
