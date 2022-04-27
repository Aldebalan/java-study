package chapter03;

import mypackage.Goods2;

public class EventGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	
	public int getDiscountPrice() {
		// protected는 자식에서 접근이 가능하다
		// 계산 중 타입이 바뀔경우 컴파일러가 잘린다고 경고해주지만
		// 명시적 표현으로 강제 실행 가능 ↓
		int discountPrice = (int)(discountRate * price);
		return discountPrice;
	}
}
