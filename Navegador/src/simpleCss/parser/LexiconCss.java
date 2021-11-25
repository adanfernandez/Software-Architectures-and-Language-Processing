package simpleCss.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LexiconCss {

	// Gestión de tokens
	List<TokenCss> tokens = new ArrayList<TokenCss>();
	int i = 0; // Último token entregado en getToken()
	// Gestión de lectura del fichero
	FileReader filereader;
	boolean charBuffUsed = false;
	char charBuff;
	int line = 1; // indica la línea del fichero fuente

	HashSet<Character> charText = new HashSet<Character>();

	public LexiconCss(FileReader f) {
		filereader = f;
		// String lex;
		try {
			char valor = (char) 0;
			while (valor != (char) -1) {
				valor = nextChar();
				switch (valor) {
				case '{':
					tokens.add(new TokenCss(TokensIdCss.LLAVE_INICIO, "{", line));
					break;
				case '}':
					tokens.add(new TokenCss(TokensIdCss.LLAVE_FIN, "}", line));
					break;
				case ':':
					tokens.add(new TokenCss(TokensIdCss.DOS_PUNTOS, ":", line));
					break;
				case ';':
					tokens.add(new TokenCss(TokensIdCss.PUNTO_COMA, ";", line));
					break;
				case '\n':
					line++;
					break;
				case '\r':
				case ' ':
				case '\t':
				case (char) -1:
					break;
				default:
					if (Character.isDigit(valor)) {
						String size = getSize("" + valor);
						if (size != null)
							tokens.add(new TokenCss(TokensIdCss.SIZE, size, line));
					} else if (Character.isAlphabetic(valor)) {
						String ident = getText("" + valor);
						switch (ident) {
						case "black":
							tokens.add(new TokenCss(TokensIdCss.BLACK, ident, line));
							break;
						case "green":
							tokens.add(new TokenCss(TokensIdCss.GREEN, ident, line));
							break;
						case "blue":
							tokens.add(new TokenCss(TokensIdCss.BLUE, ident, line));
							break;
						case "h1":
							tokens.add(new TokenCss(TokensIdCss.H1, ident, line));
							break;
						case "h2":
							tokens.add(new TokenCss(TokensIdCss.H2, ident, line));
							break;
						case "p":
							tokens.add(new TokenCss(TokensIdCss.P, ident, line));
							break;
						case "font-size":
							tokens.add(new TokenCss(TokensIdCss.FONT_SIZE, ident, line));
							break;
						case "text-align":
							tokens.add(new TokenCss(TokensIdCss.TEXT_ALIGN, ident, line));
							break;
						case "font-style":
							tokens.add(new TokenCss(TokensIdCss.FONT_STYLE, ident, line));
							break;
						case "color":
							tokens.add(new TokenCss(TokensIdCss.COLOR, ident, line));
							break;
						case "left":
							tokens.add(new TokenCss(TokensIdCss.LEFT, ident, line));
							break;
						case "right":
							tokens.add(new TokenCss(TokensIdCss.RIGHT, ident, line));
							break;
						case "center":
							tokens.add(new TokenCss(TokensIdCss.CENTER, ident, line));
							break;
						case "italic":
							tokens.add(new TokenCss(TokensIdCss.ITALIC, ident, line));
							break;
						case "bold":
							tokens.add(new TokenCss(TokensIdCss.NEGRITA, ident, line));
							break;
						case "normal":
							tokens.add(new TokenCss(TokensIdCss.NORMAL, ident, line));
							break;
						default:
							errorLexico("El caracter " + valor + " es desconocido - Línea " + line);
						}
					} else
						errorLexico("Caracter " + valor + " encontrado en línea " + line);
				}
			}
			filereader.close();
			for(TokenCss token : tokens) {
				System.out.println(token.toString());
			}
		} catch (IOException e) {
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
	public TokenCss getToken() {
		if (i < tokens.size()) {
			return tokens.get(i++);
		}
		return new TokenCss(TokensIdCss.EOF, "EOF", line);
	}

	// Recupera un token de tipo size incluyendo el px final
	String getSize(String lexStart) throws IOException {
		String lexReturned = lexStart;
		char valor;
		do {
			valor = nextChar();
			lexReturned = lexReturned + (valor);
		} while ((valor != 'p') && (valor != -1));
		// returnChar(valor);
		if (valor == 'p') {
			// lexReturned = lexReturned+(valor);
			valor = nextChar();
			if (valor == 'x') {
				lexReturned = lexReturned + (valor);
			} else {
				errorLexico("Encontrado " + lexReturned + ". Se esperada un token SIZE.");
				return null;
			}
		}
		return lexReturned;
	}

	// Recupera un token de más de 1 caracter
	String getText(String lexStart) throws IOException {
		String lexReturned = lexStart;
		char valor = nextChar();
		while (Character.isDigit(valor) || Character.isAlphabetic(valor) || (valor == '-')) {
			lexReturned = lexReturned + (valor);
			valor = nextChar();
		}
		returnChar(valor);
		return lexReturned;
	}

	boolean deleteComment() throws IOException {
		boolean r = false;
		char c = nextChar();
		if (c != '*')
			return false;
		do {
			c = nextChar();
			if (c == (char) -1) // Inesperado fin de fichero
				return false;
			if (c == '\n') // debe seguir contando líneas
				line++;
			if (c == '*') {
				c = nextChar();
				if (c == '/') {
					r = true;
				}
			}
		} while (!r);

		return r;
	}

	// Devuelve el siguiente caracter del fichero
	char nextChar() throws IOException {
		if (charBuffUsed) {
			charBuffUsed = false;
			return charBuff;
		} else {
			int valor = filereader.read();
			return ((char) valor);
		}
	}

	// Devuelve un caracter al buffer si fue leído y no consumido
	void returnChar(char r) {
		charBuffUsed = true;
		charBuff = r;
	}

	// Error léxico
	void errorLexico(String e) {
		System.out.println("Error léxico en : " + e);
	}
}
