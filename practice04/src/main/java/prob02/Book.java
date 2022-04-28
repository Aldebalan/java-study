package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode; // 0: 대여중, 1: 재고있음
	
	
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public void rent() {
		
	}
	
	public void print() {
		for(int i=0; i < 10; i++) { // 조건 수정
			boolean stateCode = true;
			System.out.println(
					"책 제목:" + title +
					"작가:" + author +
					"대여 유무:" + (stateCode ? "재고있음" : "재고없음"));
		}
	}

	
}
