import java.io.FileNotFoundException;
import java.io.FileReader;

import simpleHtml.ast.Programa;
import simpleHtml.parser.Lexicon;
import simpleHtml.parser.Parser;
import simpleHtml.visitor.PrintVisitor;


public class Main {
	static boolean logGen = true;
	
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fileReader = new FileReader("C:\\Users\\adanf\\Desktop\\aquilino\\Software-Architectures-and-Language-Processing\\Navegador\\src\\EX4.html");
		Lexicon lexicon = new Lexicon(fileReader);
		Parser parser = new Parser(lexicon);
		Programa programa = parser.parse();
		programa.toString();
		String cadena = (String)programa.accept(new PrintVisitor(), null);
		System.out.println(cadena);
	}
}