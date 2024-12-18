package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import hust.soict.dsai.aims.Aims.Aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;


public class StoreScreen extends JFrame {
	private Cart cart;
	private Store store;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		
		StoreListener sListener = new StoreListener();
		
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem book = new JMenuItem("Add Book");
		JMenuItem cd = new JMenuItem("Add CD");
		JMenuItem dvd = new JMenuItem("Add DVD");
		
		smUpdateStore.add(book);
		smUpdateStore.add(cd);
		smUpdateStore.add(dvd);
		
		book.addActionListener(sListener);
		cd.addActionListener(sListener);
		dvd.addActionListener(sListener);
		
		menu.add(smUpdateStore);
		
		JMenuItem storeView = new JMenuItem("View store");
		JMenuItem cartView = new JMenuItem("View cart");
		
		menu.add(storeView);
		menu.add(cartView);
		
		storeView.addActionListener(sListener);
		cartView.addActionListener(sListener);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		StoreListener sListener = new StoreListener();
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.cyan);
		
		JButton cart = new JButton("View cart");
		cart.addActionListener(sListener);
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItems();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("store");
		setSize(1024,768);
	}
	
	private class StoreListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("Add Book")) {
				new AddBookToStoreScreen(store);
			} else if (action.equals("Add CD")) {
				new AddCDToStoreScreen(store);
			} else if (action.equals("Add DVD")) {
				new AddDVDToStoreScreen(store);
			} else if (action.equals("View store")) {
				new StoreScreen(store, cart);
			} else if (action.equals("View cart")) {
				new CartScreen(store, cart);
			}
		}
	}
	
}
