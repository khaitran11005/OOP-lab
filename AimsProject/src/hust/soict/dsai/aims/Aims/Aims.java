package hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.*;

public class Aims {

	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove medias from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void updateMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void addMediaMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add DVD");
		System.out.println("2. Add CD");
		System.out.println("3. Add book");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void addDVDMenu() {
		System.out.println("Add DVD options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title");
		System.out.println("2. By title, category, cost");
		System.out.println("3. By title, category, director, cost");
		System.out.println("4. By title, category, director, length, cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void addCDMenu() {
		System.out.println("Add CD options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title, artist");
		System.out.println("2. By title, artist, category, cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void addBookMenu() {
		System.out.println("Add book options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title");
		System.out.println("2. By title, category, cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
		 
	private static int getOption(int upper) {
		int option = scanner.nextInt();
		String s = "Please choose a number: ";
		for (int i = 0; i < upper; ++i)
			s += i + "-";
		s += upper;
		
		while (option < 0 || option > upper) {
			System.out.println(s);
			option = scanner.nextInt();
		}
		
		return option;
	}
	
	private static Media getMediaFromStore() {
		System.out.println("Please insert media name: ");
		String input = scanner.next();
		for (Media m: store.getItems()) {
			if (m.getTitle() == input) {
				return m;
			}
		}
		System.out.println("Media not found");
		return null;
	}
	
	private static void viewStore() {
		int option = -1;
		while (option != 0) {
			storeMenu();
			store.print();
			option = getOption(4);
			scanner.nextLine();
			
			switch (option) {
			case 1:
				viewDetails(getMediaFromStore());
			case 2:
				addtoCart(getMediaFromStore());
			case 3:
				playMedia(getMediaFromStore());
			case 4:
				viewCart();
			}
		}
		
	private static void viewDetails(Media media) {
		if (media == null) {
			return;
		}
		
		int option = -1;
		while (option != 0) {
			mediaDetailsMenu();
			option = getOption(2);
			scanner.nextLine();
			switch (option) {
			case 1: 
				cart.addMedia(media);
			case 2: 
				playMedia(media);
			}
		}
	}
	
	private static void get
	
	private static void playMedia(Media media) {
		if (media == null) {
			return;
		} else if (media instanceof DigitalVideoDisc) {
			((DigitalVideoDisc) media).play();
		} else if (media instanceof CompactDisc) {
			((CompactDisc) media).play();
		} else {
			System.out.println("Can't be played.");
		}
	}
	
	private static void addtoCart

}
