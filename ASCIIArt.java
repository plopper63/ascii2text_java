//This file is not yours, blah blah blah
//Made by Ryan Maurer
// All hail Rev-o!


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
 
import javax.imageio.ImageIO;
 
public class ASCIIArt {
 
  public static void main(String[] args) throws IOException {
 
	int width = 100;    //you should know this by now :L
	int height = 30;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String inputText = null;

      //  read the text from the command-line; need to use try/catch with the readLine() method
      try {
        inputText = br.readLine();
      } catch (IOException ioe) {
         System.out.println("IO error, sad panda :c!");
         System.exit(1);
      }
        //Uncomment to enable image creation (not recommended @ all)!!
        // |
        // V
        
    //BufferedImage image = ImageIO.read(new File("logo.jpg"));
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	g.setFont(new Font("SansSerif", Font.BOLD, 24));
 
	Graphics2D graphics = (Graphics2D) g;
	graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	graphics.drawString(inputText, 10, 20);
 
	//save this image
	//ImageIO.write(image, "png", new File("ascii-art.png"));
 
	for (int y = 0; y < height; y++) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < width; x++) {
 
			sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
 
		}
 
		if (sb.toString().trim().isEmpty()) {
			continue;
		}
 
		System.out.println(sb);
	}
 
  }
 
}
