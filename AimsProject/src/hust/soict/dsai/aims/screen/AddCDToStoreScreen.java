package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCDToStoreScreen extends JFrame {
	
	private Store store;
	
	public AddCDToStoreScreen(Store store) {
		super();
		
		this.store = store;
		
		JFXPanel panel = new JFXPanel();
		
		this.setTitle("Add CD");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/fxml/AddCDToStoreScreen.fxml"));
					AddCDToStoreScreenController controller = new AddCDToStoreScreenController(store);
					loader.setController(controller);
					Parent root = loader.load();
					panel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}