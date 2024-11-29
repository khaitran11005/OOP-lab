package hust.soict.dsai.test.store.StoreTest;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(10116, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		 
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(10117, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		 
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(10205, "Aladin", "Animation", 18.99f);
		 
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(10311, "Reservoir Dogs", "Thriller", 24.99f);
		
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.removeMedia(dvd3);
		store.removeMedia(dvd4);
	}

}
