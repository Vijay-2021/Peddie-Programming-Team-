/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halloffame;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
/*
*Name is the class name so that we can load a general image and picture, e.g James Smiths picture and video will be JamesSmith.jpg and JamesSmith.mp4
*path_name is the path in which your directory is located for ease of loading images on 
*/
public class Player{  
    
   String name= "";
   String path_name = "D:\\MyProfile\\Documents\\NetBeansProjects\\HallOfFame\\src\\halloffame\\";
   //set our name variable to the players name
   public Player(String name){
       this.name = name;
   }
   public void loadImage(Stage myStage){        
       Image image = null;
           
        try {
            image = new Image(new FileInputStream(path_name+name+".jpg"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
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
     myStage.show();
     
   } 

    public void loadVideo(Stage myStage) {
        String path = path_name+"test.mp4";  
          
        //Load our file is media
        Media media = new Media(new File(path).toURI().toString());  
          
        //Plut media in a player to be played  
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
          
        //Instantiating MediaView class   
        MediaView mediaView = new MediaView(mediaPlayer);  
          
        //by setting this property to true, the Video will be played   
        mediaPlayer.setAutoPlay(true);  
          
        //setting group and scene   
        Group root = new Group();  
        root.getChildren().add(mediaView);  
        Scene scene = new Scene(root,1000,1000);  
        myStage.setScene(scene);  
        myStage.show();
  
    }
}


