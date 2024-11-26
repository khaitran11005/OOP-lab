package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
	}
	
	public String toString() {
		String string = this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() +
				" - " + this.getLength() + ": " + this.getCost() + "$";
		return string;
	}
	
	public boolean isMatch(String title) {
		if (this.title.toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}
