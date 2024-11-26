package hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	private ArrayList<Media> itemsList;
	
	public Cart() {
		itemsList = new ArrayList<Media>();
	}
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public void addMedia(Media media) {
		boolean inList = false;
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i) == media) {
				inList = true;
			}
		}
		if (inList) {
			System.out.println("Item already in cart.");
		} else {
			itemsList.add(media);
			System.out.println("Item " + media.getTitle() + " successfully added.");
		}
	}
	
	public void removeMedia(Media media) {
		boolean inList = false;
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i) == media) {
				inList = true;
				itemsList.remove(i);
				System.out.println("Item " + media.getTitle() + " successfully removed.");
			}
		}
		if (inList == false) {
			System.out.println("Item not in cart.");
			// System.out.println("it's not in the cart bro are you dumb? are you stupid?");
		} 
	}
	
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < itemsList.size(); i++) {
			cost += itemsList.get(i).getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items:");
		int no = 1;
		for (Media media: itemsList) {
			System.out.println(no + ". DVD - " + media.toString());
			no += 1;
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	public boolean searchID(int ID) {
		for (Media media: itemsList) {
			if (media.getId() == ID) {
				System.out.println("Found!");
				System.out.println(media.toString());
				return true;
			}
		}
		System.out.println("Can't find matching DVD.");
		return false;
	}
	
	public boolean searchTitle(String title) {
		for (Media media: itemsList) {
			if (media.isMatch(title)) {
				System.out.println(media.toString());
				return true;
			}
		}
		System.out.println("Can't find matching DVD.");
		return false;
	}
}
