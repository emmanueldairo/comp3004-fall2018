package core;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.control.Button;



import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class HomeScreen extends Application {
	private Button solnButton;
	private TextField leftTextBox,rightTextBox,answerBox;
	ComboBox<String> operatorDropDown;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		initUI(primaryStage);
		
	}
	
	private void initUI(Stage primaryStage) {
		Pane canvas= new Pane();
		//canvas.setStyle("-fx-background-color: black");
		
		addControlsToCanvas(canvas);
		
		Scene scene =new Scene(canvas,320,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator App");
		primaryStage.show();
	}
	private void addControlsToCanvas(Pane canvas) {
		int x=20;
		int y=60;
		int txtBoxWidth=50;
		Label label= new Label("Simple Calculator App using Javafx");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
		label.relocate(x,x);
		
		leftTextBox =new TextField();
		leftTextBox.setMaxWidth(txtBoxWidth);
		leftTextBox.relocate(x,y);
		
		operatorDropDown = new ComboBox<String>();
		operatorDropDown.getItems().addAll("+","-","x","/","%");
		operatorDropDown.setValue("+");
		operatorDropDown.relocate(80, y);
		
		rightTextBox =new TextField();
		rightTextBox.setMaxWidth(txtBoxWidth);
		rightTextBox.relocate(150,y);
		
		solnButton =new Button("=");
		solnButton.relocate(210,y);
		
		
		answerBox = new TextField();
		answerBox.setMaxWidth(txtBoxWidth);
		answerBox.setEditable(false);
		answerBox.relocate(250, y);
		
		setSolnBottonClickHandler();
		
		canvas.getChildren().addAll(label,leftTextBox,rightTextBox,operatorDropDown,solnButton,answerBox);
		
	}
	private void setSolnBottonClickHandler() {
		solnButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Double leftBox=  Double.valueOf(leftTextBox.getText());
				Double rightBox=  Double.valueOf(rightTextBox.getText());
				String operator= operatorDropDown.getValue();
				ArithmeticSolver solver= new ArithmeticSolver();
				
				String answer= String.valueOf(solver.solve(operator,leftBox,rightBox));

				answerBox.setText(answer);
			}
		});		
	}
	

}
