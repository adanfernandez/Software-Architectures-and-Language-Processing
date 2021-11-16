import java.io.FileReader;

import ast.Ast;

public class Main {
	static boolean logGen = true;
	
	public static void main(String[] args) {
		Ast htmlAst = null;
		AstCss cssAst = null;
		AstCss defaultCss = null;
		
		try {
			FileReader fileHtml = new FileReader("EX$.html");
			HtmlAstCreator htmlAstCreator = new HtmlAstCreator();
			htmlAst = htmlAstCreator.getHtmlAst(fileHtml);
			log("Creado el árbol del html");
			
			BuscarCss bcss = new BuscarCss();
			String css = (String)htmlAst.accept(null, bcss)
		}
	}
}