package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class Cart {
	private ArrayList<DigitalVideoDisc> itemsList;
	private int qtyOrdered;
	
	public Cart() {
		itemsList = new ArrayList<>();
		qtyOrdered = 0;
	}
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsList.add(disc);
			qtyOrdered += 1;
			System.out.println("Item successfully added.");
		} else {
			System.out.println("Cart is full!");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int qty = 0;
		for (DigitalVideoDisc d: dvdList) {
			qty += 1;
		}
		if (qtyOrdered + qty <= MAX_NUMBERS_ORDERED) {
			for (DigitalVideoDisc d: dvdList) {
				itemsList.add(d);
				qtyOrdered += 1;
				System.out.println("Item successfully added.");
			}
		}
		else {
			System.out.println("Cart limit exceeded.");
		}
	}
	

	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		switch (qtyOrdered) {
		case MAX_NUMBERS_ORDERED - 1:
			System.out.println("Not enough space for both DVDs in the cart!");
			break;
		case MAX_NUMBERS_ORDERED:
			System.out.println("Not enough space for another DVD in the cart!");
			break;
		default:
			itemsList.add(dvd1);
			itemsList.add(dvd2);
			qtyOrdered += 2;
			System.out.println("Both items successfully added.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsList.contains(disc)) {
			int temp = itemsList.indexOf(disc);
			itemsList.remove(temp);
			qtyOrdered -= 1;
			System.out.println(String.join(" ", "Item", disc.getTitle(), "successfully removed."));
		} else {
			System.out.println("Item not found in cart.");
		}
	}
	
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsList.get(i).getCost();
		}
		return cost;
	}
	
	public int getQuantity() {
		return qtyOrdered;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items:");
		int no = 1;
		for (DigitalVideoDisc dvd: itemsList) {
			System.out.println(no + ". DVD - " + dvd.toString());
			no += 1;
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	public boolean searchID(int ID) {
		for (DigitalVideoDisc dvd: itemsList) {
			if (dvd.getId() == ID) {
				System.out.println("Found!");
				System.out.println(dvd.toString());
				return true;
			}
		}
		System.out.println("Can't find matching DVD.");
		return false;
	}
	
	public boolean searchTitle(String title) {
		for (DigitalVideoDisc dvd: itemsList) {
			if (dvd.isMatch(title) == true) {
				System.out.println(dvd.toString());
				return true;
			}
		}
		System.out.println("Can't find matching DVD.");
		return false;
	}
}
