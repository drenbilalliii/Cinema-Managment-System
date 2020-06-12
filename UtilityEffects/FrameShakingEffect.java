/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityEffects;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Dren
 */


// (x,y + 5) ..
public class FrameShakingEffect {

    
    
  private final static int TIME_SHAKINGLENGTH = 20; // e ndryshoj nashta me vone njeher qekjo po pershtatet
  private final static int POSITEMOVEBY = 5;
  
  public FrameShakingEffect() { }
  
  public static void vibrate(Frame frame) { 
    try { 
      final int originalLocationX = frame.getLocationOnScreen().x; 
      final int originalLocationY = frame.getLocationOnScreen().y; 
      for(int i = 0; i < TIME_SHAKINGLENGTH; i++) { 
        Thread.sleep(5); 
        frame.setLocation(originalLocationX, originalLocationY + POSITEMOVEBY); 
        Thread.sleep(5); 
        frame.setLocation(originalLocationX, originalLocationY - POSITEMOVEBY);
        Thread.sleep(5); 
        frame.setLocation(originalLocationX + POSITEMOVEBY, originalLocationY);
        Thread.sleep(5); 
        //normalizo frame  ne gjendjen fillestare.
        frame.setLocation(originalLocationX, originalLocationY);  
      } 
    } 
    catch (Exception err) { 
      err.printStackTrace(); 
    } 
  }
}