package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	
	private TableView<Media> tblMedia;
	private TableColumn<Media, String> colMediaTitle;
	private TableColumn<Media, String> colMediaCategory;
	private TableColumn<Media, Float> colMediaCost;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsList());
	}
}
