package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.*;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    private Boolean mode;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    void penButtonPressed(ActionEvent event) {
    	mode = true;
    }
    
    void eraserButtonPressed(ActionEvent event) {
    	mode = false;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (mode) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4);
    		newCircle.setFill(Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
    	} else if (mode == false) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4);
    		newCircle.setFill(Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
    	}
    }

}

