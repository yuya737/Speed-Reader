import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	Scanner text;
	int wordcount;
	int sentencount;
	public WordGenerator(String filename) throws IOException{
		text = new Scanner(new File (filename));
	}
	public boolean hasNext(){
		return text.hasNext();
	}
	public String next(){
		String nextWord = text.next();
		this.wordcount++;
		if (nextWord.contains(".") || nextWord.contains("!") || nextWord.contains("?") ){this.sentencount++;}
		return nextWord;
	}
	public int getWordCount(){
		return this.wordcount;
		
	}
	public int getSentenceCount(){
		return this.sentencount;
	}
}
