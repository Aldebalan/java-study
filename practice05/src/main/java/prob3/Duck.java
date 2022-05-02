package prob3;

public class Duck extends Bird {

	@Override
	public String toString() {
		return "오리의 이름은 " + name + " 입니다";
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("오리"+"("+name+")는" + " 날지 않습니다.");

	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("오리"+"("+name+")는" + " 소리내어 웁니다.");

	}

}
