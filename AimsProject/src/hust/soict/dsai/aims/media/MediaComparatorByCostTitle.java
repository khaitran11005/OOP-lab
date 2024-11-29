package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}
	
	public int compare(Media a, Media b) {
		
		if (a.getCost() != b.getCost()) {
			return a.getCost() > b.getCost() ? -1 : 1;
		}
		
		return a.getTitle().compareTo(b.getTitle());
	}

}