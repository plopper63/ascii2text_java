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
import java.io.*;			//lets us prepare for an IOException from getting input
import java.util.*;
 
import javax.imageio.ImageIO;
 
public class ASCIIArt {
	public static void main(String[] args) throws IOException, InterruptedException {
		int width = 100;    //you should know this by now :L
		int height = 30;
		int fontSize = 18;
		
		String inputText = null;
		String saveInputText = null;
		String charSymbol = "#";
		
		// =================================================================================================================
	    // Starts input routines, uses Scanner for int(s), and BufferedReader for strings (for looks, I know it sucks...)
	    // =================================================================================================================
		
		Scanner input = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter text: ");
		try {
			inputText = br.readLine();
		}
		catch (IOException ioe) {
			System.out.println("IO error, sad panda :c!");
			System.exit(1);
		}
		
		System.out.println("Enter symbol: ");
		try {
			charSymbol = br.readLine();
		}
		catch (IOException ioe) {
			System.out.println("IO error, sad panda :c!");
			System.exit(1);
		}
		System.out.println("Enter font size: ");
        fontSize = input.nextInt();	
        
        // =================================================================================================================
	    // Graphics stuff, creates temporary image in buffer (image) and 'converts' it to "binary layout"
	    // =================================================================================================================
        
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("Monospaced", Font.BOLD, fontSize));
		
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
	    graphics.drawString(inputText, 10, 20);
	    
	    // =================================================================================================================
	    // "Builds" the string, trims it, then replaces gaps with spaces, and non-gaps with user-defined symbol (charSymbol)
	    // =================================================================================================================
	    
	    for (int y = 0; y < height; y++) {
	    	StringBuilder sb = new StringBuilder();
	    	for (int x = 0; x < width; x++) {
	    		sb.append(image.getRGB(x, y) == -16777216 ? " " : charSymbol);
	    	}
	    	if (sb.toString().trim().isEmpty()) {
	    		continue;
	    	}
	    	System.out.println(sb);
	    }
	    
	    // =================================================================================================================
	    // Draws and sets up input for save function.
	    // =================================================================================================================
	    
	    BufferedReader saveInput = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("--------------------------------------------------------------------------------");
	    System.out.println("Save? (y/n):");
	    
	    
	    //  accept userInput for save (y/n)?
	    try {
	    	saveInputText = saveInput.readLine();
	    }
	    catch (IOException ioe) {
	    	System.out.println("IO error, sad panda :c!");
	    	System.exit(1);
	    }
	    // =================================================================================================================
	    // determines user choice for save input 
	    // =================================================================================================================
	    if(saveInputText.toLowerCase() == "y") {
	    	ImageIO.write(image, "png", new File("H:/ascii-art.png"));
	    	System.out.println("[Saved!]");
	    	Thread.sleep(1500);
	    	System.exit(1);
	    }
	    if(saveInputText.toLowerCase() == "n") {
	    	System.out.println("Ok, bye then!");
	    	System.exit(1);
	    }
	}
}
