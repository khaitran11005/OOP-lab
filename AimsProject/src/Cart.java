import java.util.ArrayList;
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
				itemsList.add(disc);
				qtyOrdered += 1;
				System.out.println("Item successfully added.");
			}
		}
		else {
			System.out.println("Cart limit exceeded.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		int qty = 0;
		for (DigitalVideoDisc d: dvdList) {
			qty += 1;
		}
		if (qtyOrdered + qty <= MAX_NUMBERS_ORDERED) {
			for (DigitalVideoDisc d: dvdList) {
				itemsList.add(disc);
				qtyOrdered += 1;
				System.out.println("Item successfully added.");
			}
		}
		else {
			System.out.println("Cart limit exceeded.")
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
}