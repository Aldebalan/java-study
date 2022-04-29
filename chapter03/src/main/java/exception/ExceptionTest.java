package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;

		System.out.println("some code.....1");

		try {
			System.out.println("some code.....2");

			int result = (1 + 2 + 3) / b;

			System.out.println("some code......3");

		} catch (ArithmeticException ex) {
			// 예외 처리
			// 1. 사과 
			System.out.println("Sorry.");
			// 2. 로깅 (logging) 기록
			System.out.println("error:" + ex);
			// 3. 정상종료
			return;
		} finally {
			System.out.println("자원 정리");
		}
	}
}
