package hust.soict.dsai.aims.screen;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddBookToStoreScreenController {
	
	private Store store;
	private static String title;
	private static String category;
	private static float cost;
	private static ArrayList<String> authors;
	private static String curAuthor;
    @FXML
    private MenuItem addBookOption;

    @FXML
    private MenuItem addCDOption;

    @FXML
    private MenuItem addDVDOption;

    @FXML
    private Button authorButton;

    @FXML
    private TextField authorField;

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
    
    public AddBookToStoreScreenController(Store store) {
    	this.store = store;
    }
    
    private void initialize() {
    	titleField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddBookToStoreScreenController.title = newValue;
    			}
    		}
    	});
    	categoryField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddBookToStoreScreenController.category = newValue;
    			}
    		}
    	});
    	costField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				try{
    					AddBookToStoreScreenController.cost = Float.parseFloat(newValue);
    				} catch (NumberFormatException e) {
    					AddBookToStoreScreenController.cost = 0.0f;
    					// i can't even bother
    				}
    			}
    		}
    	});
    	authorField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddBookToStoreScreenController.curAuthor = newValue;
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
    void authorButtonPressed(ActionEvent event) {
    	if (curAuthor != null) {
    		AddBookToStoreScreenController.authors.add(curAuthor);
    	}
    }

    @FXML
    void finalButtonPressed(ActionEvent event) {
    	if (title != null && category != null) {
    		if (authors != null) {
    			store.addMedia(new Book(0, title, category, cost, authors));
    		} else {
    			store.addMedia(new Book(0, title, category, cost));
    		}
    	}
    }

    @FXML
    void viewCartOptionPressed(ActionEvent event) {
    	new CartScreen(store, new Cart());
    }

    @FXML
    void viewStoreOptionPressed(ActionEvent event) {
    	new StoreScreen(store, new Cart());
    }

}
