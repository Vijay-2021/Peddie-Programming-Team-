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
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class HallOfFame extends Application {  
    Image image;
    Stage myStage = new Stage();
    boolean poor = false;
   @Override
   public void start(Stage myStages) throws FileNotFoundException {   
       
        //Setting the image view
        Parent roots = null;
      //Setting the image view
        try {
            roots = FXMLLoader.load(getClass().getResource("testing.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene newScene = new Scene(roots);
       myStage.setScene(newScene);

       myStage.show();
        
            
        
     
   }
   
   @FXML
    public void handleButton1Action(){
        Player player1 = new Player("player1");
        player1.loadVideo(myStage); 
    }
   public static void main(String args[]) {
    
      launch(args);
   }
}


