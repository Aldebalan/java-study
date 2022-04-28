package chapter03;

public class Goods {
	
	public static int countOfGoods;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods(String name) {
//		countOfGoods = countOfGoods + 1;
//		this.name = name;
		this(name, 0, 0, 0);
	}
	
//	public Goods() {
//		this(null,0,0,0);
//	}
	
	public Goods() {
		Goods.countOfGoods = Goods.countOfGoods + 1;		
	}
	
	public Goods(String name, int price, int countStock, int countSold) {
		Goods.countOfGoods = Goods.countOfGoods + 1;		

		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		// this가 없으면 지역변수 name이 내부에서 돌면서 찾을 수 없다
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		// 데이터 보호 (값 음수 설정 불가)
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println(
				"name:" + name +
				", price:" + price +
				", countStock:" + countStock +
				", countSold:" + countSold);
	}

	public int calcDiscountPrice(double discountRate) {
		return (int)(discountRate * price);
	}
	
}
