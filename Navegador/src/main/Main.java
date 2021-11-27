package main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import render.LineaFormated;
import render.PageFormated;
import render.Render;
import render.TextoFormated;
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
		printPage(page);
	}
	
	
	private static void printPage(PageFormated page) {
		System.out.println("\n\n\nTítulo:" + page.getTitle());
		for(LineaFormated linea : page.getLineas()) {
			String align = linea.getAlign();
			System.out.println("\n(Line align: " + align + " | Metrics: " + linea.calcularMetricas() + ">>");
			printFormat(linea.getTextos());
		}
	}


	private static void printFormat(List<TextoFormated> textos) {
		String style = "";
		String cadena =  "";
		Double metric = 0.0;
		for(TextoFormated texto : textos) {
			if(style.equals(texto.getStyle())) {
				cadena += " " + texto.getContenido();
			} else {
				if(!style.equals("")) {
					cadena += ")\n";
					cadena = String.format(cadena, metric.toString());
					metric = 0.0;
				}
				cadena += "\tFormat: " + texto.getColor() + ", " + texto.getSize() + ", " + texto.getStyle() + ", " +  texto.getWidth() + " | Metrics: %s" + " >> " + texto.getContenido();
			}
			style = texto.getStyle();
			metric += texto.calculateMetrics();
		}
		cadena += ")";
		if(metric != 0) cadena = String.format(cadena, metric.toString());
		System.out.println(cadena);
	}
}