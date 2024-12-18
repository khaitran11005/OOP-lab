package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddDVDToStoreScreenController {
	
	private Store store;
	
	private static String title;
	private static String category;
	private static float cost;
	private static String director;
	private static int length;

    @FXML
    private MenuItem addBookOption;

    @FXML
    private MenuItem addCDOption;

    @FXML
    private MenuItem addDVDOption;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField costField;

    @FXML
    private TextField directorField;

    @FXML
    private Button finalButton;

    @FXML
    private TextField lengthField;

    @FXML
    private TextField titleField;

    @FXML
    private MenuItem viewCartOption;

    @FXML
    private MenuItem viewStoreOption;
    
    public AddDVDToStoreScreenController(Store store) {
    	this.store = store;
    }
    
    private void initialize() {
    	titleField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddDVDToStoreScreenController.title = newValue;
    			}
    		}
    	});
    	categoryField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddDVDToStoreScreenController.category = newValue;
    			}
    		}
    	});
    	costField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				try{
    					AddDVDToStoreScreenController.cost = Float.parseFloat(newValue);
    				} catch (NumberFormatException e) {
    					AddDVDToStoreScreenController.cost = 0.0f;
    					// i can't even bother
    				}
    			}
    		}
    	});
    	directorField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				AddDVDToStoreScreenController.director = newValue;
    			}
    		}
    	});
    	lengthField.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			if (newValue != null) {
    				try{
    					AddDVDToStoreScreenController.length = Integer.parseInt(newValue);
    				} catch (NumberFormatException e) {
    					AddDVDToStoreScreenController.length = 0;
    					// nor can i bother here
    				}
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
    	if (title != null && category != null) {
    		if (director != null) {
    			store.addMedia(new DigitalVideoDisc(0, title, category, cost, length, director));
    		} else {
    			store.addMedia(new DigitalVideoDisc(0, title, category, cost));
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

