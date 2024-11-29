package hust.soict.dsai.aims.media;
import java.util.*;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}
	
	public int compare(Media a, Media b) {
		int titleSort = a.getTitle().compareTo(b.getTitle());
		if (titleSort == 0) {
			return a.getCost() > b.getCost() ? -1 : 1;
		}
		return titleSort;
	}
}
