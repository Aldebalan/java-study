package tv;

public class TV {
	private int channel; // 0 ~ 255 rotation
	private int volume; // 0 ~ 100 rotation
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
	}

	public void volume(int volume) {
		// rotation
		if (volume < 0) {
			this.volume = 0;
		} else if (volume > 100){
			this.volume = 100;
		} else {
			this.volume = volume;
		}
	}

	public void power(boolean b) {
		power = b;
	}

	public void channel(int b) {
		channel = b;
	}

	public void channel(boolean b) {
		channel(channel + (b ? 1 : -1));
	}

	public void status() {
		System.out.println("TV channel =" + channel + ", volume =" + volume + ", power =" + (power ? "on" : "off"));
	}

}
