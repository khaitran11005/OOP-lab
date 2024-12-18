package hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.*;

import javax.swing.JOptionPane;

public class Aims {

	public static Store store = new Store();
	public static Cart cart = new Cart();
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
		System.out.println("1. By ID, title, category, cost");
		System.out.println("2. By ID, title, category, cost, length, director");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void addCDMenu() {
		System.out.println("Add CD options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By ID, title, category, cost, artist");
		System.out.println("2. By ID, title, category, cost, artist, director, length");
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
	
	public static void viewStore() throws PlayerException {
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
				cart.print();
			}
		
		}
	}
		
	private static void viewDetails(Media media) throws PlayerException {
		if (media == null) {
			return;
		}
		
		int option = -1;
		while (option != 0) {
			System.out.println(media.toString());
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
	
	public static void addtoCart(Media media) {
		if (media == null) {
			return;
		}
		
		cart.addMedia(media);
		JOptionPane.showMessageDialog(null, "Added media, total media in cart: " + cart.returnCount(), "AIMS", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void playMedia(Media media) throws PlayerException {
		if (media == null) {
			return;
		} else if (media instanceof DigitalVideoDisc) {
			try {
				((DigitalVideoDisc) media).play();
				JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle(), "AIMS", JOptionPane.INFORMATION_MESSAGE);
			} catch (PlayerException e) {
				JOptionPane.showMessageDialog(null, "Error: DVD length is non-positive", "Illegal DVD length", JOptionPane.ERROR_MESSAGE);
			}
		} else if (media instanceof CompactDisc) {
			try {
				((CompactDisc) media).play();
				JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle(), "AIMS", JOptionPane.INFORMATION_MESSAGE);
			} catch (PlayerException e) {
				JOptionPane.showMessageDialog(null, "Error: CD length is non-positive, or one of the tracks' length is non-positive", "Illegal CD length", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			throw new PlayerException("Can't play the media!");
		}
	}
	
	private static void updateStore() {
		int option = -1;
		while (option != 0) {
			updateMenu();
			option = getOption(2);
			scanner.nextLine();
			switch (option) {
			case 1:
				addMedia();
			case 2:
				store.removeMedia(getMediaFromStore());
			}
		}
	}
	
	private static void addMedia() {
		int option = -1;
		while (option != 0) {
			addMediaMenu();
			option = getOption(3);
			scanner.nextLine();
			switch (option) {
			case 1:
				addDvd();
			case 2:
				addCd();
			case 3:
				addBook();
			}
		}
	}
	
	public static void addDvd() {
		
		String title = "";
		String category = "";
		String director = "";
		int length = 0;
		float cost = 0;
		int id = 0;
		
		int option = -1;
		while (option != 0) {
			addDVDMenu();
			option = getOption(2);
			scanner.nextLine();
			switch (option) {
			case 1:
				System.out.println("Enter ID");
				id = scanner.nextInt();
				System.out.println("Enter title");
				title = scanner.nextLine();
				System.out.println("Enter category");
				category = scanner.nextLine();
				System.out.println("Enter cost");
				cost = scanner.nextFloat();
				store.addMedia(new DigitalVideoDisc(id, title, category, cost));
			case 2:
				System.out.println("Enter ID");
				id = scanner.nextInt();
				System.out.println("Enter title");
				title = scanner.nextLine();
				System.out.println("Enter category");
				category = scanner.nextLine();
				System.out.println("Enter cost");
				cost = scanner.nextFloat();
				System.out.println("Enter director");
				director = scanner.nextLine();
				System.out.println("Enter length");
				length = scanner.nextInt();
				store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
			}
		}
	}
	
	public static void addCd() {
		String title = "";
		String category = "";
		String director = "";
		int length = 0;
		float cost = 0;
		int id = 0;
		String artist = "";
		
		int option = -1;
		while (option != 0) {
			addDVDMenu();
			option = getOption(2);
			scanner.nextLine();
			switch (option) {
			case 1:
				System.out.println("Enter ID");
				id = scanner.nextInt();
				System.out.println("Enter title");
				title = scanner.nextLine();
				System.out.println("Enter category");
				category = scanner.nextLine();
				System.out.println("Enter cost");
				cost = scanner.nextFloat();
				System.out.println("Enter artist");
				artist = scanner.nextLine();
				store.addMedia(new CompactDisc(id, title, category, cost, artist));
			case 2:
				System.out.println("Enter ID");
				id = scanner.nextInt();
				System.out.println("Enter title");
				title = scanner.nextLine();
				System.out.println("Enter category");
				category = scanner.nextLine();
				System.out.println("Enter cost");
				cost = scanner.nextFloat();
				System.out.println("Enter artist");
				artist = scanner.nextLine();
				System.out.println("Enter director");
				director = scanner.nextLine();
				System.out.println("Enter length");
				length = scanner.nextInt();
				store.addMedia(new CompactDisc(id, title, category, cost, length, director, artist));
			}
		}
	}

	public static void addBook() {
		String title = "";
		String category = "";
		float cost = 0;
		int id = 0;
		
		System.out.println("Enter ID");
		id = scanner.nextInt();
		System.out.println("Enter title");
		title = scanner.nextLine();
		System.out.println("Enter category");
		category = scanner.nextLine();
		System.out.println("Enter cost");
		cost = scanner.nextFloat();
		store.addMedia(new Book(id, title, category, cost));
	}
	
	private static void viewCart() throws PlayerException {
		int option = -1;
		while (option != 0) {
			cartMenu();
			option = getOption(5);
			scanner.nextLine();
			switch (option) {
			case 1:
				filterCart();
			case 2:
				sortCart();
			case 3:
				removeMedia(getMediaFromStore());
			case 4:
				playMedia(getMediaFromStore());
			case 5:
				placeOrder();
			}
		}
	}
	
	private static void removeMedia(Media media) {
		if (media == null) {
			return;
		} else {
			cart.removeMedia(media);
		}
	}
	
	private static int getIdFromInput() {
		System.out.println("Enter ID");
		return scanner.nextInt();
	}
	
	private static String getTitleFromInput() {
		System.out.println("Enter title");
		return scanner.nextLine();
	}
	
	private static void filterCart() {
		int option = -1;
		while (option != 0) {
			filterMenu();
			option = getOption(2);
			scanner.nextLine();
			switch (option) {
			case 1:
				cart.searchID(getIdFromInput());
			case 2:
				cart.searchTitle(getTitleFromInput());
			}
		}
	}
	
	private static void sortCart() {
		int option = -1;
		while (option != 0) {
			filterMenu();
			option = getOption(2);
			scanner.nextLine();
			switch (option) {
			case 1:
				cart.sortTitle();
			case 2:
				cart.sortCost();
			}
		}
	}
	
	public static void placeOrder() {
		System.out.println("Order placed");
		cart.clearCart();
	}
	
	public static void main(String[] args) throws PlayerException {
		int option = -1;
		while (option != 0) {
			showMenu();
			option = getOption(3);
			scanner.nextLine();
			switch (option) {
			case 1:
				viewStore();
			case 2:
				updateStore();
			case 3:
				viewCart();
			}
		}
	}
}
