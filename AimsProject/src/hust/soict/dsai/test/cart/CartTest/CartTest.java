package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// new cart
		Cart cart = new Cart();
		
		// new test dvd objects
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		 
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		 
		 DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		 
		 DigitalVideoDisc dvd4 = new DigitalVideoDisc("Reservoir Dogs", "Thriller", 24.99f);
		 
		 cart.addDigitalVideoDisc(dvd1, dvd2);
		 cart.addDigitalVideoDisc(dvd3, dvd4);
		 
		 cart.print();
		 
		 System.out.println(dvd1.getId());
		 System.out.println(dvd3.getId());
		 cart.searchID(2);
		 cart.searchID(9);
		 cart.searchTitle("Star ");
		 cart.searchTitle("Reservoir Dogs");
	}

}
