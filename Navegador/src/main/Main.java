package main;
import java.io.FileNotFoundException;
import java.io.FileReader;

import render.PageFormated;
import render.Render;
import simpleCss.parser.LexiconCss;
import simpleCss.parser.ParserCss;
import simpleCss.visitor.BuscarParametrosCssVisitor;
import simpleHtml.ast.Programa;
import simpleHtml.parser.LexiconHtml;
import simpleHtml.parser.ParserHtml;


public class Main {
	static boolean logGen = true;
	public static void main(String[] args) throws FileNotFoundException {
		//FileReader fileReader = new FileReader("C:\\Users\\uo251162\\Documents\\Software-Architectures-and-Language-Processing\\Navegador\\src\\EX4.html");
		FileReader fileReaderHtml = new FileReader("src\\EX4.html");
		LexiconHtml lexiconHtml = new LexiconHtml(fileReaderHtml);
		
		
		ParserHtml parserHtml = new ParserHtml(lexiconHtml);
		Programa programa = parserHtml.parse();		
		
		
		
		
		
		FileReader fileReaderCss = new FileReader("src\\EX1.css");
		LexiconCss lexiconCss = new LexiconCss(fileReaderCss);
		ParserCss parserCss = new ParserCss(lexiconCss);
		simpleCss.ast.ProgramaCss prCss = parserCss.parse();
		prCss.toString();
		
		fileReaderCss = new FileReader("src\\Default.css");
		lexiconCss = new LexiconCss(fileReaderCss);
		ParserCss defaultParserCss = new ParserCss(lexiconCss);
		simpleCss.ast.ProgramaCss defaultPrCss = defaultParserCss.parse();
		defaultPrCss.toString();
		
		
		
		Render render = new Render(new BuscarParametrosCssVisitor(), prCss, defaultPrCss);
		PageFormated page = (PageFormated) render.visit(programa, null);
		System.out.println(page);
	}
}