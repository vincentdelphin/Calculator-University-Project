package uk.ac.rhul.cs2800;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller class for the GuiView.fxml file.
 * 
 * @author Vincent
 *
 */

public class CalcController extends Application {
  private Stage primaryStage;
  private VBox mainLayout;
  @FXML
  private RadioButton reversePolish = new RadioButton();
  @FXML
  private RadioButton infix = new RadioButton();
  @FXML
  private TextField text = new TextField();

  private boolean standardN;

  private CalcModel calcModel;

  /**
   * Constructor for CalcController.
   * 
   * 
   */
  public CalcController() {
    calcModel = new CalcModel();
  }

  /**
   * Main method to run controller.
   * 
   * @param args arguments passed through by user.
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Calculates expression passed through by user.
   * 
   * @param e action event is the button pressed.
   * @throws BadTypeExpo thrown when incorrect getter is found.
   * @throws InvalidExpression thrown when wrong expression is passed through.
   */
  public void calculate(ActionEvent e) throws BadTypeExpo, InvalidExpression {

    if (text.getText().length() == 0) {
      infix.setSelected(false);
      reversePolish.setSelected(false);
      return;
    }

    standardN = radioisPressed();

    if (standardN) {
      String input = text.getText();
      String result = Float.toString(calcModel.evaluate(input, standardN));
      text.setText(result);
      return;
    } else {
      String input = text.getText();
      String result = Float.toString(calcModel.evaluate(input, standardN));
      text.setText(result);
    }



  }


  /**
   * Method to determine if the standard infix notation is being passed through by the user.
   * 
   * @return returns true or false dependent on if the standard infix button is pressed or not.
   * @throws InvalidExpression thrown when wrong expression is passed through
   */
  public boolean radioisPressed() throws InvalidExpression {
    if (infix.isSelected()) {
      return true;
    } else if (reversePolish.isSelected()) {
      return false;
    } else {
      text.setText("Please select notation.");
      throw new InvalidExpression();
    }

  }



  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Calculator");
    showMainView();
    Scene scene = new Scene(mainLayout);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  private void showMainView() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(CalcController.class.getResource("GuiView.fxml"));
    mainLayout = loader.load();
  }
}
