package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Disc extends Media {
	
	protected int length;
	protected String director;

	public Disc() {
		super();
	}
	
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		
	}
	
}
