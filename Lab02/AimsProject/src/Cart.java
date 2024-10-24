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
