import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.lang.Math;
import javafx.scene.layout.GridPane;
import java.util.Scanner;

public class SlideGame extends Application{
  
  //stores the array of buttons that represents the screen
  private Button[][] buttons;
  
  /** 
   * creates the GUI display
   * @param primaryStage the main window
   */
  public void start(Stage primaryStage) {
    //stores the width/length of the board
    int width=4;
    int length=4;
    
    buttons = new Button[length][width];
    GridPane grid = new GridPane();
    //initializes every button as a blank button
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        buttons[i][j] = new Button("  ");
      }
      grid.addRow(i, buttons[i]);
    }
    
    //stores the two indices to start one random square off as one
    int indOne = (int) (Math.random() * width);
    int indTwo = (int) (Math.random() * length);
    buttons[indOne][indTwo].setText("1");    
   
    //buttons on the left side clicked uses an anonymous class
    //these buttons not corner
    buttons[1][0].setOnAction(this :: leftMove);
    buttons[2][0].setOnAction(this :: leftMove);
    
    //buttons on the right side clicked uses an anonymous class
    //these buttons not corner
    buttons[1][3].setOnAction(this :: rightMove);
    buttons[2][3].setOnAction(this :: rightMove);
    
    //buttons on the right side clicked uses an anonymous class
    //these buttons not corner
    buttons[0][1].setOnAction(e -> upMove(e));
    buttons[0][2].setOnAction(e -> upMove(e));
    
    //buttons on the right side clicked uses an anonymous class
    //these buttons not corner
    buttons[3][1].setOnAction(e -> downMove(e));
    buttons[3][2].setOnAction(e -> downMove(e));
    
    //new scene for the grid
    Scene scene = new Scene(grid);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /** 
   * deneme metodu
   * @param ActionEvent e for event
   */
  public void leftMove(ActionEvent e){
   System.out.println("deneme1");
  }
  
  /** 
   * deneme metodu
   * @param ActionEvent e for event
   */
  public void rightMove(ActionEvent e){
   System.out.println("deneme2");
  }
  
  /** 
   * deneme metodu
   * @param ActionEvent e for event
   */
  public void upMove(ActionEvent e){
   System.out.println("deneme3");
  }
  
  /** 
   * deneme metodu
   * @param ActionEvent e for event
   */
  public void downMove(ActionEvent e){
   System.out.println("deneme4");
  }
   
   /** 
   * helper method to convert from an array of ints to an array of buttons
   * @param ints an array of ints
   */
  public void intToButton(int[][] ints) {
    //loops through each of the ints to set the text on buttons
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] == 0) {
          buttons[i][j].setText("  ");
        }
        else {
          buttons[i][j].setText(Integer.toString(ints[i][j]));
        }
      }
    }
  }
  
  /**
   * helper method to convert an array of buttons to an array of ints
   * @param buttons an array of buttons
   * @return an array of ints
   */
  public int[][] buttonToInt(Button[][] buttons) {
    //stores the final array of ints
    int[][] finalArray = new int[buttons.length][buttons[0].length];
    //runs through each button intiliaze ints based off the text
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons[i].length; j++) {
        if (buttons[i][j].getText().equals("  ")) {
          finalArray[i][j] = 0;
        }
        else {
          
          finalArray[i][j] = Integer.parseInt(buttons[i][j].getText());
        }
      }
    }
    return finalArray;
  }
  
  /**
   * helper method to generate an extra one
   * @param ints an array of ints
   * @return an array of ints with a new one tile
   */
  public static int[][] addOne(int[][] ints) {
    int indOne = (int) (Math.random() * ints.length);
    int indTwo = (int) (Math.random() * ints[0].length);
    //stores whether or not there is an empty space
    boolean isSpace = false;
    //checks to make sure that there is an empty space
    for (int i = 0; i < ints.length; i++) {
      for(int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] == 0) {
          isSpace = true;
        }
      }
    }
    //if there is space on the board, it will keep generating numbers until it hits a blank space
    while (ints[indOne][indTwo] != 0 && isSpace) {
      indOne = (int) (Math.random() * ints.length);
      indTwo = (int) (Math.random() * ints[0].length);
    } 
    ints[indOne][indTwo] = 1;
    return ints;
  }
  
    /**
   * helper to determine the number of non-zeroes in a method, to test addOne
   * @param ints a multidimensional array
   * @return the number of non-zeros in the method
   */
  public static int numberNonZero(int[][] ints) {
    int numNonZero = 0;
    //loops through the array
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] != 0) {
          numNonZero++;
        }
      }
    }
    return numNonZero;
  }
   
  /** 
    * The main method to run the program  
    * @param args the command line arguments  
    */ 
  public static void main(String[] args) { 
    SlideGame.launch(args);              
  }
}