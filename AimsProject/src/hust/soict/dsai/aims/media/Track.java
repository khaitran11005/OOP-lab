package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	
	private String title;
	private int length;
	
	public Track() {
		this.title = null;
		this.length = 0;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public void play() throws PlayerException {
		if (this.length <= 0) {
			throw new PlayerException("aaaaaaaaaaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		} else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}
	
	public boolean equals(Object track) {
		Track castTrack = (Track) track;
		if (this.title == castTrack.getTitle() && this.length == castTrack.getLength()) {
			return true;
		} else {return false;}
	}
}
