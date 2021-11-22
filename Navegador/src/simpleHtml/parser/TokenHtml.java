package simpleHtml.parser;


public class TokenHtml {
	TokensIdHtml token;
	String lexeme;
	int line;
	
	public TokenHtml (TokensIdHtml token, String lexeme, int line) {
		this.token = token;
		this.lexeme = lexeme;
		this.line = line;
	}
	
	public TokensIdHtml getToken () {
		return token;
	}
	
	public String getLexeme () {
		return lexeme;
	}
	
	public int getLine() {
		return line;
	}

	public String toString() {
		return "TOKEN: "+token+" - LEXEMA: "+lexeme+" - LINE: "+line;
	}
}
