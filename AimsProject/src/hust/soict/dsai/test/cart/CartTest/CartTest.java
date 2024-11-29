package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// new cart
		Cart cart = new Cart();
		
		// new test dvd objects
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc(10116, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		 
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc(10117, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		 
		 DigitalVideoDisc dvd3 = new DigitalVideoDisc(10205, "Aladin", "Animation", 18.99f);
		 
		 DigitalVideoDisc dvd4 = new DigitalVideoDisc(10311, "Reservoir Dogs", "Thriller", 24.99f);
		 
		 cart.addMedia(dvd1);
		 cart.addMedia(dvd2);
		 cart.addMedia(dvd3);
		 cart.addMedia(dvd4);
		 
		 cart.print();
		 
		 System.out.println(dvd1.getId());
		 System.out.println(dvd3.getId());
		 cart.searchID(2);
		 cart.searchID(9);
		 cart.searchTitle("Star ");
		 cart.searchTitle("Reservoir Dogs");
	}

}
