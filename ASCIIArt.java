// =================================================================================================================
// This file is not yours, blah blah blah
// Made by Ryan Maurer
// Reads text input from console and 'converts' it to a binary layout (see example below) 
//	H =		(font size is 18 for this example)
//
//	1111001111			****  ****
//	1111001111			****  ****
//	0110000110			 **    ** 
//	0110000110			 **    **
//	0111111110			 ********
//	0111111110			 ********
//	0110000110			 **    **
//	0110000110			 **    **
//	0110000110			 **    **
//	1111001111			****  ****
//	1111001111			****  ****
// =================================================================================================================



import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
 
public class ASCIIArt {
   public static Scanner input = new Scanner(System.in);
   public static void main(String[] args) throws IOException, InterruptedException {
      
      int width;    //you should know this by now :L
      int height;  
      
      int fontSize;
      String saveLocation = null;
      String saveInputText = null;
      String inputText = null;
      String symbol = "#";
      String invertedBoolString = "n";
      
      // ==================================================================================
      // Input routine; accepts width, height, text, symbol, fontsize, and inversion on/off
      // ==================================================================================

      System.out.println("Width?: ");
      width = input.nextInt();
      input.nextLine();
      
      System.out.println("Height?: ");
      height = input.nextInt();
      input.nextLine();
      
      System.out.println("What text?: ");
      inputText = input.nextLine();
          
      System.out.println("Font size?: ");
      fontSize = input.nextInt();
      input.nextLine();
      
      System.out.println("And the symbol?: ");
      symbol = input.nextLine();
      
      System.out.println("Do you want to invert it? [Y/n]: ");
      invertedBoolString = input.nextLine();
      
      // ==================================================
      // Initializes Graphics stuff
      // ==================================================
    
      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      Graphics g = image.getGraphics();
      //g.setFont(new Font("Script MT Bold", Font.PLAIN, fontSize));
      g.setFont(new Font("Bodoni MT", Font.BOLD, fontSize));
   	
      Graphics2D graphics = (Graphics2D) g;
      graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
   	
      // ==================================================
      // Check if inversion is enabled/disabled
      // ==================================================
      
      if((!invertedBoolString.toLowerCase().equals("y")) && (!invertedBoolString.toLowerCase().equals("n"))) {
         System.out.println("Non-valid input entered: Defaulting to 'No inversion.'");
         System.out.println("Continuing in: ");
         System.out.print("3");
         Thread.sleep(1000);
         System.out.print("2");
         Thread.sleep(1000);
         System.out.print("1");
         Thread.sleep(1000);
      }
   	
      System.out.println("\n");      
      for(int z = 0; z < width; z++) {
        System.out.print("-");
      }
      System.out.println("\n");
      
   	  // ==================================================
      // Use StringBuilder to "assemble" string
      // ==================================================
      
      graphics.drawString(inputText, 4, 24);
      
      for (int y = 0; y < height; y++) {
         StringBuilder sb = new StringBuilder();
         for (int x = 0; x < width; x++) {
            if(invertedBoolString.toLowerCase().equals("y")) {
               sb.append(image.getRGB(x, y) == -16777216 ? symbol : " ");
            }
            if(invertedBoolString.toLowerCase().equals("n")) {
               sb.append(image.getRGB(x, y) == -16777216 ? " " : symbol);
            }
            if((!invertedBoolString.toLowerCase().equals("y")) && (!invertedBoolString.toLowerCase().equals("n"))) {
               sb.append(image.getRGB(x, y) == -16777216 ? " " : symbol);
            }
         }
      
         if (sb.toString().trim().isEmpty()) {
            continue;
         }
         System.out.println(sb);
      }
      
   
          
      for(int z = 0; z < width; z++) {
        System.out.print("-");
      }
      System.out.println("\n");
      System.out.println("[" + width + "x" + height + "]");
      
      // ==================================================
      // Input for save preference
      // ==================================================
      
      System.out.print("Save? (y/n):");
      //System.out.println(save);
      saveInputText = input.nextLine();
      
      if(saveInputText.toLowerCase().equals("y")) {	
         System.out.print("Where do you want to save it? ([DRIVE]:/[FILENAME]): ");
         saveLocation = input.nextLine();
         
         File testing = new File(saveLocation + ".png");
         //ImageIO.write(image, "png", new File("E:/ascii-art.png"));
         ImageIO.write(image, "png", testing);
         System.out.println("[Saved to: '" + saveLocation + ".png']");
         Thread.sleep(1000);
         System.exit(1);
      }
      if(saveInputText.toLowerCase().equals("n")) {
         Thread.sleep(500);
         System.out.println("Ok, bye then!");
         System.exit(1);
      }
   }
}
