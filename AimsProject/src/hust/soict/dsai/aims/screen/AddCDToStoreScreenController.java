package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddCDToStoreScreenController {
	
	private Store store;
	private static String title;
	private static String category;
	private static float cost;
	private static String artist;

    @FXML
    private MenuItem addBookOption;

    @FXML
    private MenuItem addCDOption;

    @FXML
    private MenuItem addDVDOption;

    @FXML
    private TextField artistField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField costField;

    @FXML
    private Button finalButton;

    @FXML
    private TextField titleField;

    @FXML
    private MenuItem viewCartOption;

    @FXML
    private MenuItem viewStoreOption;
    
    public AddCDToStoreScreenController(Store store) {
    	this.store = store;
    }
    
    private void initialize() {
    	titleField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddCDToStoreScreenController.title = newValue;
    			}
    		}
    	});
    	categoryField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddCDToStoreScreenController.category = newValue;
    			}
    		}
    	});
    	costField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				try{
    					AddCDToStoreScreenController.cost = Float.parseFloat(newValue);
    				} catch (NumberFormatException e) {
    					AddCDToStoreScreenController.cost = 0.0f;
    					// i can't even bother
    				}
    			}
    		}
    	});
    	artistField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddCDToStoreScreenController.artist = newValue;
    			}
    		}
    	});
    }

    @FXML
    void addBookOptionPressed(ActionEvent event) {
    	new AddBookToStoreScreen(store);
    }

    @FXML
    void addCDOptionPressed(ActionEvent event) {
    	new AddCDToStoreScreen(store);
    }

    @FXML
    void addDVDOptionPressed(ActionEvent event) {
    	new AddDVDToStoreScreen(store);
    }

    @FXML
    void finalButtonPressed(ActionEvent event) {
    	if (title != null && category != null && artist != null) {
    		store.addMedia(new CompactDisc(0, title, category, cost, artist));
    	}
    }

    @FXML
    void viewCartOptionPressed(ActionEvent event) {
    	new CartScreen(store, new Cart());
    }

    @FXML
    void viewStoreOptionPressed(ActionEvent event) {
    	new CartScreen(store, new Cart());
    }

}
