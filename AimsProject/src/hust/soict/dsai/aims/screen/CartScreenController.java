package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private Store store;
	
	private TableView<Media> tblMedia;
	private TableColumn<Media, String> colMediaTitle;
	private TableColumn<Media, String> colMediaCategory;
	private TableColumn<Media, Float> colMediaCost;
    private Button btnPlay;
    private Button btnRemove;
    private Button orderButton;
    private Label totalCostLabel;
    private ToggleGroup filterCategory;
    private MenuItem addBookOption;
    private MenuItem addCDOption;
    private MenuItem addDVDOption;
    private MenuItem viewStoreOption;
    private MenuItem viewCartOption;
	
	public CartScreenController(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
	}
	
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsList());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				if (newValue!=null) {
					updateButtonBar(newValue);
				}
			}
		});
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}
	
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCostLabel.setText(cart.totalCost() + " $");
	}
	
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		media.play();
		totalCostLabel.setText(cart.totalCost() + " $");
	}
	
	void orderButtonPlaced(ActionEvent event) {
		cart.clearCart();
		totalCostLabel.setText(cart.totalCost() + " $");
	}
	
	void addBookOptionPressed(ActionEvent event) {
		new AddBookToStoreScreen(store);
	}
	
	void addDVDOptionPressed(ActionEvent event) {
		
	}
	
	void addCDOptionPressed(ActionEvent event) {
		
	}
	
	void viewStoreOptionPressed(ActionEvent event) {
		new StoreScreen(store, cart);
	}
	
	void viewCartOptionPressed(ActionEvent event) {
		new CartScreen(store, cart);
	}
}
