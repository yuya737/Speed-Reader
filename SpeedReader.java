import java.awt.*;
import java.io.IOException;

public class SpeedReader {
	public static void SpeedRead(String filename, int width, int height,int fontSize, int wpm) throws IOException, InterruptedException{
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		
		Font f = new Font("Courier", Font.BOLD, fontSize);
		
		g.setFont(f);
		FontMetrics fontstuff = g.getFontMetrics(f);
		
		
		WordGenerator words = new WordGenerator(filename);
		
		while(words.hasNext()){
			panel.clear();
			String toPrint = words.next();
		
			int placementWidth = (width - fontstuff.stringWidth(toPrint)) / 2;
			
			g.drawString(toPrint, placementWidth, height/2);
			Thread.sleep((long)((double) 60.0 / (double) wpm * (double) 1000.0));

			
		}
		panel.clear();
		String wordcount = "Wordcount: " + Integer.toString(words.wordcount);
		g.drawString(wordcount, (width - fontstuff.stringWidth(wordcount)) / 2, height/2);
		Thread.sleep((long)((double) 60.0 / (double) wpm * (double) 1000.0));
		panel.clear();
		String sentencecount = "Sentencecount: " + Integer.toString(words.sentencount);
		g.drawString(sentencecount, (width - fontstuff.stringWidth(sentencecount)) / 2, height/2);
		Thread.sleep((long)((double) 60.0 / (double) wpm * (double) 1000.0));
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException, InterruptedException {
		if (args.length != 5){
			System.out.println("Valid input is in the format: SpeedReader <filename> <width> <height> <font size> <wpm>");
			}
		else {
		SpeedRead(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
		}
	}
}
