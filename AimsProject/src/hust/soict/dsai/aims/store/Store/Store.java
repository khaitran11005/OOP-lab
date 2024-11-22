package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<>();
	}
	
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore.add(disc);
		System.out.println("Added " + disc.toString());
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (itemsInStore.contains(disc)) {
			int temp = itemsInStore.indexOf(disc);
			itemsInStore.remove(temp);
			System.out.println("Removed " + disc.toString());
		} else {System.out.println("Disc not found.");}
	}
}
