package prob2;

public class SmartPhone extends Phone {
	// 다 상속으로 분리하기
	@Override
	public void execute(String function) {
		if("음악".equals(function)) {
			playMusic();
			return;
		} else if("통화".equals(function)) {
			playCall();
			return;
		} else if("앱".equals(function)) {
			playApp();
			return;
		}
		super.execute(function);
	}
	protected void playMusic() {
		System.out.println("MP3 플레이어에서 음악 재생");
	}
	protected void playCall() {
		System.out.println("통화기능시작");
	}
	protected void playApp() {
		System.out.println("앱 실행");
	}
}
