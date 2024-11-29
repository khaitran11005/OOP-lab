package hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Cart anOrder = new Cart();
		 
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc(10116, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		 anOrder.addMedia(dvd1);
		 
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc(10117, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		 anOrder.addMedia(dvd2);
		 
		 DigitalVideoDisc dvd3 = new DigitalVideoDisc(10205, "Aladin", "Animation", 18.99f);
		 anOrder.addMedia(dvd3);
		 
		 Track kingKunta = new Track("King Kunta", 4);
		 Track alright = new Track("Alright", 3);
		 Track mortalMan = new Track("Mortal Man", 12);
		 ArrayList<Track> tracklist = new ArrayList<Track>();
		 tracklist.add(kingKunta);
		 tracklist.add(mortalMan);
		 tracklist.add(alright);
		 CompactDisc cd1 = new CompactDisc(20109, "To Pimp A Butterfly", "Rap", 11.99f, 78, "Dave Free", "Kendrick Lamar", tracklist);
		 
		 Book book1 = new Book(30019, "House of Leaves", "Horror", 21.99f);
		 book1.addAuthor("Mark Z. Danielewski");
		 
		 // System.out.print("Total cost is: ");
		 // System.out.println(anOrder.totalCost());
		 
		 // anOrder.removeMedia(dvd3);
		 
		 DigitalVideoDisc dvd4 = new DigitalVideoDisc(10311, "Reservoir Dogs", "Thriller", 24.99f);
		 // anOrder.removeMedia(dvd4);
		 
		 // System.out.print("Total cost is: ");
		 // System.out.println(anOrder.totalCost());
		 
		 // System.out.print("Number of items in cart is: ");
		 // System.out.println(anOrder.getQuantity());
		 
		 List<Media> mediae = new ArrayList<Media>();
		 
		 mediae.add(dvd1);
		 mediae.add(cd1);
		 mediae.add(book1);
		 
		 for (Media m: mediae) {
			 System.out.println(m.toString());
		 }
		 
	}

}
