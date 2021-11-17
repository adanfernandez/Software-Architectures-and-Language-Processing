import java.io.FileNotFoundException;
import java.io.FileReader;

import simpleHtml.parser.Lexicon;


public class Main {
	static boolean logGen = true;
	
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fileReader = new FileReader("C:\\Users\\uo251162\\Documents\\Software-Architectures-and-Language-Processing\\Navegador\\src\\EX4.html");
		Lexicon lexicon = new Lexicon(fileReader);
	}
}