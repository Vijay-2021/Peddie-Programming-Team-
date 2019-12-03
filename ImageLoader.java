package halloffame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ImageLoader extends Application {  
    Image image;
   
   @Override
   public void start(Stage myStage) throws FileNotFoundException {        
      //Creating an image
       GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 200);

        rootNode.add(new Label("Filename"), 0, 0);
        TextField firstValue = new TextField();
        rootNode.add(firstValue, 1, 0);
       
        Button aButton = new Button("Input");
        rootNode.add(aButton, 1, 1);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);
        rootNode.add(result, 1, 2);

        aButton.setOnAction(e -> {
            String value= firstValue.getText();
             
           try {
               image = new Image(new FileInputStream("D:\\MyProfile\\Documents\\NetBeansProjects\\HallOfFame\\src\\halloffame\\"+value+".png"));
           } catch (FileNotFoundException ex) {
               Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
           }
     
      //Setting the image view
      ImageView imageView = new ImageView(image);
      imageView.setX(50);
      imageView.setY(25);
     
      //setting the fit height and width of the image view
      imageView.setFitHeight(455);
      imageView.setFitWidth(500);
     
      //Setting the preserve ratio of the image view
      imageView.setPreserveRatio(true);  
      Group root = new Group(imageView);  
     
      
      Scene scene = new Scene(root, 600, 500);  
      myStage.setScene(scene);
        });
     
     
     
     
   }  
   public static void main(String args[]) {
      launch(args);
   }
}

