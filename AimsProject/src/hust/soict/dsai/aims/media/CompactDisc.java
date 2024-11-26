package hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc {
	
	private String artist;
	private ArrayList<Track> tracks;

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track trackName) {
		boolean inList = false;
		for (int i = 0; i < this.tracks.size(); i++) {
			if (this.tracks.get(i) == trackName) {
				inList = true;
			}
		}
		if (inList) {
			System.out.println("Track already in tracklist.");
		} else {
			this.tracks.add(trackName);
			System.out.println("Track " + trackName.getTitle() + " successfully added.");
		}
	}
	
	public void removeTrack(Track trackName) {
		boolean inList = false;
		for (int i = 0; i < this.tracks.size(); i++) {
			if (this.tracks.get(i) == trackName) {
				inList = true;
				this.tracks.remove(i);
				System.out.println("Track " + trackName.getTitle() + " successfully removed.");
			}
		}
		if (inList == false) {
			System.out.println("Track not in tracklist.");
		} 
	}
	
	public int getLength() {
		int total = 0;
		for (int i = 0; i < this.tracks.size(); i++) {
			total += this.tracks.get(i).getLength();
		}
		return total;
	}
	
}
