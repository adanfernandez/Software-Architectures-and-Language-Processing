package simpleHtml.parser;

import java.io.FileReader;
import java.util.*;
import java.io.*;

public class LexiconHtml {

	// Gestión de tokens
	List<TokenHtml> tokens = new ArrayList<TokenHtml>();
	int i = 0; // Último token entregado en getToken()
	// Gestión de lectura del fichero
	FileReader filereader;
	boolean charBuffUsed = false;
	char charBuff;
	int line = 1; // indica la línea del fichero fuente

	HashSet<Character> charText = new HashSet<Character>();

	public LexiconHtml(FileReader f) {
		/*
		 * tokens.add(new Token(TokensId.HTML, "<html>")); tokens.add(new
		 * Token(TokensId.HTMLCLOSE, "</html>"));
		 */
		filereader = f;
		String lex;
		loadSet();
		try{
			char valor=(char) 0;
			while(valor!=(char) -1){
				valor=nextChar();
				switch ((char) valor) {
				case '<':
					valor=nextChar();
					if ((char) valor == '/') {
						valor=nextChar();
						switch ((char) valor) {
						case 'h':
							lex = getLexeme ("</h",'>');
							if (lex.equals("</html>"))
								tokens.add(new TokenHtml(TokensIdHtml.HTMLC, lex, line));
							else if (lex.equals("</head>"))
								tokens.add(new TokenHtml(TokensIdHtml.HEADC, lex, line));
							else if (lex.equals("</h1>"))
								tokens.add(new TokenHtml(TokensIdHtml.H1C, lex, line));
							else if (lex.equals("</h2>"))
								tokens.add(new TokenHtml(TokensIdHtml.H2C, lex, line));
							else
								errorLexico(lex);
							break;
						case 'p':
							lex = getLexeme ("</p",'>');
							if (lex.equals("</p>"))
								tokens.add(new TokenHtml(TokensIdHtml.PC, lex, line));
							else
								errorLexico(lex);
							break;
						case 't':
							lex = getLexeme ("</t",'>');
							if (lex.equals("</title>"))
								tokens.add(new TokenHtml(TokensIdHtml.TITLEC, lex, line));
							else
								errorLexico(lex);
							break;
						case 'b':
							lex = getLexeme ("</b",'>');
							if (lex.equals("</body>"))
								tokens.add(new TokenHtml(TokensIdHtml.BODYC, lex, line));
							else if (lex.equals("</b>"))
								tokens.add(new TokenHtml(TokensIdHtml.NEGRITAC, lex, line));
							else
								errorLexico(lex);
							break;
						case 'i':
							lex = getLexeme ("</i",'>');
							if (lex.equals("</i>"))
								tokens.add(new TokenHtml(TokensIdHtml.CURSIVAC, lex, line));
							else
								errorLexico(lex);
							break;
						case 'u':
							lex = getLexeme ("</u",'>');
							if (lex.equals("</u>"))
								tokens.add(new TokenHtml(TokensIdHtml.UNDERLINEC, lex, line));
							else
								errorLexico(lex);
							break;
						default:
							errorLexico(getLexeme("<"+valor, '>'));
						}
					}
					else {
						switch ((char) valor)  {
						case 'l':
							lex = getLexeme ("<l",'k');
							if (lex.equals("<link"))
								tokens.add(new TokenHtml(TokensIdHtml.LINKI, lex, line));
							else
								errorLexico(lex);
							break;
						case 'h':
							lex = getLexeme ("<h",'>');
							if (lex.equals("<html>"))
								tokens.add(new TokenHtml(TokensIdHtml.HTMLI, lex, line));
							else if (lex.equals("<head>"))
								tokens.add(new TokenHtml(TokensIdHtml.HEADI, lex, line));
							else if (lex.equals("<h1>"))
								tokens.add(new TokenHtml(TokensIdHtml.H1I, lex, line));
							else if (lex.equals("<h2>"))
								tokens.add(new TokenHtml(TokensIdHtml.H2I, lex, line));
							else
								errorLexico(lex);
							break;
						case 'p':
							lex = getLexeme ("<p",'>');
							if (lex.equals("<p>"))
								tokens.add(new TokenHtml(TokensIdHtml.PI, lex, line));
							else
								errorLexico(lex);
							break;
						case 't':
							lex = getLexeme ("<t",'>');
							if (lex.equals("<title>"))
								tokens.add(new TokenHtml(TokensIdHtml.TITLEI, lex, line));
							else
								errorLexico(lex);
							break;
						case 'b':
							lex = getLexeme ("<b",'>');
							if (lex.equals("<body>"))
								tokens.add(new TokenHtml(TokensIdHtml.BODYI, lex, line));
							else if (lex.equals("<b>"))
								tokens.add(new TokenHtml(TokensIdHtml.NEGRITAI, lex, line));
							else
								errorLexico(lex);
							break;
						case 'i':
							lex = getLexeme ("<i",'>');
							if (lex.equals("<i>"))
								tokens.add(new TokenHtml(TokensIdHtml.CURSIVAI, lex, line));
							else
								errorLexico(lex);
							break;
						case 'u':
							lex = getLexeme ("<u",'>');
							if (lex.equals("<u>"))
								tokens.add(new TokenHtml(TokensIdHtml.UNDERLINEI, lex, line));
							else
								errorLexico(lex);
							break;
						default:
							errorLexico(getLexeme("<"+valor, '>'));
						
						}
					}
					break;
				case '>':
						tokens.add(new TokenHtml(TokensIdHtml.CIERRE, new String(">"), line));
					break;
				case '"':
					String cadena = getLexeme("", '"');
					cadena = cadena.substring(0, cadena.length() -1);
					tokens.add(new TokenHtml(TokensIdHtml.CADENA, cadena, line));
					break;
				case '\n':
					line++;
				case '\r':
				case ' ':
				case '=':
				case '\t':
				case (char)-1:
					//Eliminar todos los espacios TokensId.WS
					break;
				default:
					//Texto
					lex = getLexemeTEXT(new String(""+(char)valor));
					switch (lex) {
						case "href":
							tokens.add(new TokenHtml(TokensIdHtml.HREFI, lex, line));
							break;
						case "rel":
							tokens.add(new TokenHtml(TokensIdHtml.RELI, lex, line));
							break;
						case "type":
							tokens.add(new TokenHtml(TokensIdHtml.TYPEI, lex, line));
							break;
						default:
							tokens.add(new TokenHtml(TokensIdHtml.TEXTO, lex, line));
							break;
					}
				}
				//System.out.print((char)valor);
			}
			filereader.close();
			for(TokenHtml token : tokens) {
				//System.out.println(token.toString());
			}
        }
		 catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}

	}

	// ++
	// ++ Operaciones para el Sintactico
	// ++
	// Devolver el último token
	public void returnLastToken() {
		i--;
	}

	// Get Token
	public TokenHtml getToken() {
		if (i < tokens.size()) {
			return tokens.get(i++);
		}
		return new TokenHtml(TokensIdHtml.EOF, "EOF", line);
	}
	// ++
	// ++ Operaciones para el Sintactico
	// ++

	// Privadas

	// Dado el inicio de una cadena y el caracter final, devuelve el lexema
	// correspondiente
	String getLexeme(String lexStart, char finChar) throws IOException {
		String lexReturned = lexStart;
		char valor;
		do {
			valor = nextChar();
			lexReturned = lexReturned + ((char) valor);
		} while (((char) valor != finChar) && ((char) valor != -1));
		// returnChar(valor);
		return lexReturned;
	}

	// Devuelve un lexema de texto, el caracter final es un espacio
	String getLexemeTEXT(String lexStart) throws IOException {
		String lexReturned = lexStart;
		char valor = nextChar();
		while (charText.contains(((char) valor)) && ((char) valor != -1)) {
			lexReturned = lexReturned + ((char) valor);
			valor = nextChar();
		}
		returnChar(valor);
		return lexReturned;
	}

	// Carga el conjunto de caracteres adminidos pro el analizador léxico
	void loadSet() {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.,;:+-*/()[]!?";
		int i = 0;
		Character a = new Character('a');
		while (i < s.length()) {
			a = s.charAt(i);
			charText.add(a);
			i++;
		}
		// System.out.println(charText);
	}

	// Devuelde el siguiente caracter de fuente
	char nextChar() throws IOException {
		if (charBuffUsed) {
			charBuffUsed = false;
			return charBuff;
		} else {
			int valor = filereader.read();
			return ((char) valor);
		}
	}

	// Devuelve un caracger que se ha leído pero no se ha consumido al buffer
	void returnChar(char r) {
		charBuffUsed = true;
		charBuff = r;
	}

	// Emite error léxico
	void errorLexico(String e) {
		System.out.println("Error léxico en : " + e);
	}

	public TokenHtml getActualToken() {
		if (i < tokens.size() && i > 0) {
			return tokens.get(i-1);
		}
		return new TokenHtml (TokensIdHtml.EOF,"EOF", line);
	}
}
