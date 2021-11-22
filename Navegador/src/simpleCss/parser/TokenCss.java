package simpleCss.parser;


public class TokenCss {
	TokensIdCss token;
	String lexeme;
	int line;
	
	public TokenCss (TokensIdCss token, String lexeme, int line) {
		this.token = token;
		this.lexeme = lexeme;
		this.line = line;
	}
	
	public TokensIdCss getToken () {
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
