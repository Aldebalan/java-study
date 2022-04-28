package prob05;

public class MyBase extends Base {
	
	public void service(String state){
		if( state.equals( "낮" ) ) {
			day();
		} else {
			night();
		}
	}
	
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	public void night(){
//		this.night();
//		System.out.println("night");
		System.out.println("오후에도 일하자");
	}
	
	
	
}
