package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc() {
		super();
		nbDigitalVideoDiscs += 1;
	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		nbDigitalVideoDiscs += 1;
	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		nbDigitalVideoDiscs += 1;
	}

	public String toString() {
		String string = this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() +
				" - " + this.getLength() + ": " + this.getCost() + "$";
		return string;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}
