package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		Scanner s=new Scanner(System.in);
		System.out.println(intArray.length+"개의 정수를 입력하시오>>");
		
		for(int i=0; i<intArray.length; i++) {
			intArray[i]=s.nextInt(); sum+=intArray[i];
			}
		/* 배열에 저장된 정수 값 더하기 */
		
		/* 출력 */
		System.out.print("합은 "+(double)sum/intArray.length);
		/* 자원정리 */
		scanner.close();
	}
}
