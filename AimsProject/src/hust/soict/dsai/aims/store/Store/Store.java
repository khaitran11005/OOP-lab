package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<>();
	}
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("Added " + media.toString());
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			int temp = itemsInStore.indexOf(media);
			itemsInStore.remove(temp);
			System.out.println("Removed " + media.toString());
		} else {System.out.println("Item not found.");}
	}
	
	public void print() {
		for (Media m: itemsInStore) {
			System.out.println(m.toString());
		}
	}
	
	public ArrayList<Media> getItems() {
		return this.itemsInStore;
	}
}
