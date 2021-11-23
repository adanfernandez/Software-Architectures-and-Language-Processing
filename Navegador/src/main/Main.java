package main;
import java.io.FileNotFoundException;
import java.io.FileReader;

import simpleHtml.ast.Programa;
import simpleHtml.parser.LexiconHtml;
import simpleHtml.parser.ParserHtml;
import simpleHtml.visitor.PrintVisitor;


public class Main {
	static boolean logGen = true;
	public static void main(String[] args) throws FileNotFoundException {
		//FileReader fileReader = new FileReader("C:\\Users\\uo251162\\Documents\\Software-Architectures-and-Language-Processing\\Navegador\\src\\EX4.html");
		FileReader fileReaderHtml = new FileReader("src\\EX4.html");
		LexiconHtml lexiconHtml = new LexiconHtml(fileReaderHtml);
		ParserHtml parserHtml = new ParserHtml(lexiconHtml);
		Programa programa = parserHtml.parse();
		
		PrintVisitor printVisitor = new PrintVisitor();
		System.out.println(printVisitor.visit(programa, null));
		
		/*
		FileReader fileReaderCss = new FileReader("src\\EX1.css");
		LexiconCss lexiconCss = new LexiconCss(fileReaderCss);
		ParserCss parserCss = new ParserCss(lexiconCss);
		simpleCss.ast.ProgramaCss prCss = parserCss.parse();
		prCss.toString();
		*/
		
	}
}