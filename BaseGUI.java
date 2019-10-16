/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kochsnowflake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author vshah-21
 */

public class BaseGUI extends JFrame implements MouseListener, MouseMotionListener {
    Graphics2D g2d;
    BufferedImage backbuffer;
    double WIDTH;
    double HEIGHT;
    public boolean mouse_being_pressed = false;
    public double mouse_x = 0;
    public double mouse_y=0;
    public BaseGUI(String name){
        
        super(name);
        addMouseListener(this);//the mouselisteners, listens for any mouse events 
        addMouseMotionListener(this);
        
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("we are hree?");
        setVisible(true);
        backbuffer = new BufferedImage(800,800,BufferedImage.TYPE_INT_RGB);//creates a buffered image which graphics will be drawn on 
        g2d= backbuffer.createGraphics();//set our graphics to be drawn on this image
        g2d.setColor(Color.WHITE);
        WIDTH =800;
        HEIGHT=800;
    }
    public BaseGUI(String name,int width, int height){
        super(name);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
         backbuffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//creates a buffered image which graphics will be drawn on 
        g2d= backbuffer.createGraphics();
        WIDTH=width;
        HEIGHT=height;
    }
    
    public void paint(Graphics g){
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(backbuffer,0,0,this);
        
        //System.out.println("annoying");
    }
    /**
     * Call this once to save uncessary repainting each time run
     */
    public void update(){
         
        repaint();
    }
    
    /**
     * Base methods
     */
    public void drawPoint(double x, double y){
        int x2 = (int)x;
        int y2 = (int)y;
        g2d.drawLine(x2, y2, x2, y2);
        
    }
    public void resetCanvas(){
        update();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,(int)WIDTH, (int)HEIGHT);
    }
    public void changeColor(double r, double b, double g){
        int r2 = (int)r;
        int b2 = (int)b;
        int g2 = (int)g;
        g2d.setColor(new Color(r2,b2,g2));
        
    }
    public void fillRect(double x, double y, double width, double height){
        g2d.fillRect((int)x,(int)y,(int)width,(int)height);
    }
    public void drawRect(double x, double y, double width, double height){
        g2d.drawRect((int)x,(int)y,(int)width,(int)height);
    }
    public void drawLine(double x1, double y1, double x2, double y2){
        int nX1 = (int)x1;
        int nX2= (int)x2;
        int nY1 = (int)y1;
        int nY2= (int)y2;
        g2d.drawLine(nX1,nY1,nX2,nY2);
     
   }
   public void drawShape(double[] x, double[] y){
       if(x.length==y.length){
       int[] x2 = new int[x.length];
       int[] y2 = new int[y.length];
       for(int i =0; i < x.length; i++){
           x2[i]=(int)x[i];
           y2[i]=(int)y[i];
       }
      
       g2d.drawPolygon(x2,y2,x2.length);
       }else{
           return;
       }
   }
   public void fillShape(double[] x, double[] y){
       if(x.length==y.length){
       int[] x2 = new int[x.length];
       int[] y2 = new int[y.length];
       for(int i =0; i < x.length; i++){
           x2[i]=(int)x[i];
           y2[i]=(int)y[i];
       }
      
       g2d.fillPolygon(x2,y2,x2.length);
       }else{
           return;
       }
   }
    public void mouseClicked(MouseEvent e) {
        
    }
    public void mousePressed(MouseEvent e) {
        mouse_being_pressed = true;
        int mouseX = e.getX();//stores the x and y of the mouse 
        int mouseY = e.getY();
        mouse_x = mouseX;
        mouse_y=mouseY;
    }

    public void mouseReleased(MouseEvent e) {
        mouse_being_pressed = false;
        int mouseX = e.getX();//stores the x and y of the mouse 
        int mouseY = e.getY();
        mouse_x = mouseX;
        mouse_y=mouseY;
    }
    public boolean mouseBeingPressed(){
        return mouse_being_pressed;
    }
    public double mouse_x(){
        return mouse_x;
    }
    public double mouse_y(){
        return mouse_y;
    }
    public void mouseEntered(MouseEvent e) {
    
    }
    
    public void mouseExited(MouseEvent e) {
    
    }

    public void mouseDragged(MouseEvent e) {
      
    }

    public void mouseMoved(MouseEvent e) {
        
    }
    
    
}
