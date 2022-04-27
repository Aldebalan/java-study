package prob01;

import java.util.Scanner;

public class Member {
	
	Scanner scan = new Scanner(System.in);
	
	private int id ;
	private String name;
	private int point;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}