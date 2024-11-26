package hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Cart anOrder = new Cart();
		 
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		 anOrder.addMedia(dvd1);
		 
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		 anOrder.addMedia(dvd2);
		 
		 DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		 anOrder.addMedia(dvd3);
		 
		 System.out.print("Total cost is: ");
		 System.out.println(anOrder.totalCost());
		 
		 anOrder.removeMedia(dvd3);
		 
		 DigitalVideoDisc dvd4 = new DigitalVideoDisc("Reservoir Dogs", "Thriller", 24.99f);
		 anOrder.removeMedia(dvd4);
		 
		 System.out.print("Total cost is: ");
		 System.out.println(anOrder.totalCost());
		 
		 // System.out.print("Number of items in cart is: ");
		 // System.out.println(anOrder.getQuantity());
	}

}
