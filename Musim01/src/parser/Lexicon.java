package parser;

import java.io.FileReader;
import java.util.*;
import java.io.*;

public class Lexicon {

	// Gestión de tokens
	List<Token> tokens = new ArrayList<Token>();
	int i = 0; //Último token entregado en getToken()
	//Gestión de lectura del fichero
	FileReader filereader;
	boolean charBuffUsed = false;
	char charBuff;
	int line = 1; // indica la línea del fichero fuente
	
	HashSet<Character> charText = new HashSet<Character>();
	
	public Lexicon (FileReader f) {
		filereader = f;
		String lex;
		loadSet();
		try{
			char valor=(char) 0;
			while(valor!=(char) -1){
				valor=nextChar();
				switch (valor) {
				case 'M':
					tokens.add(new Token(TokensId.M, ""+valor, line));
					break;
				case 'R':
					tokens.add(new Token(TokensId.R, ""+valor, line));
					break;
				case 'W':
					tokens.add(new Token(TokensId.W, ""+valor, line));
					break;
				case '{':
					tokens.add(new Token(TokensId.LLA, ""+valor, line));
					break;
				case '}':
					tokens.add(new Token(TokensId.LLC, ""+valor, line));
					break;
				case ';':
					tokens.add(new Token(TokensId.PYC, ""+valor, line));
					break;
				case '=':
					tokens.add(new Token(TokensId.EQ, ""+valor, line));
					break;
				case '+':
					tokens.add(new Token(TokensId.MAS, ""+valor, line));
					break;
				case '-':
					tokens.add(new Token(TokensId.MENOS, ""+valor, line));
					break;
				case '*':
					tokens.add(new Token(TokensId.MULT, ""+valor, line));
					break;
				case '/':
					tokens.add(new Token(TokensId.DIV, ""+valor, line));
					break;
				case '(':
					tokens.add(new Token(TokensId.PARABRE, ""+valor, line));
					break;
				case ')':
					tokens.add(new Token(TokensId.PARCIERRA, ""+valor, line));
					break;
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					tokens.add(new Token(TokensId.VARIABLE, ""+valor, line));
					break;
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					tokens.add(new Token(TokensId.CONSTANTE, ""+valor, line));
					break;
					/*
				case '"':
					//Cadena entre comillas
					lex = getLexeme ("\"",'"');
					tokens.add(new Token(TokensId.URL, lex, line));
					break;
					*/
				case '\n':
					line++;
				case '\r':
				case ' ':
				case '\t':
				case (char)-1:
					//Eliminar todos los espacios TokensId.WS
					break;
				default:
					/*Texto
					lex = getLexemeTEXT(new String(""+(char)valor));
					tokens.add(new Token(TokensId.TEXT, lex, line));*/
					errorLexico ("No se esperaba el caracter "+valor);
					break;
				}
				//System.out.print((char)valor);
			}
			filereader.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
		
	}
	
	// ++
	// ++ Operaciones para el Sintactico
	// ++
	// Devolver el último token
	public void returnLastToken () {
		i--;
	}
	
	// Get Token
	public Token getToken () {
		if (i < tokens.size()) {
			return tokens.get(i++);
		}
		return new Token (TokensId.EOF,"EOF", line);
	}	
	
	// reset
	public void reset () {
		this.i = 0;
	}
	// ++
	// ++ Operaciones para el Sintactico
	// ++

	//Privadas
	String getLexeme (String lexStart, char finChar) throws IOException {
		String lexReturned = lexStart;
		char valor;
		do {
			valor=nextChar();
			lexReturned = lexReturned+((char) valor);
		} while (((char) valor != finChar) && ((char) valor != -1));
		//returnChar(valor);
		return lexReturned;
	}
	
	String getLexemeTEXT (String lexStart) throws IOException {
		String lexReturned = lexStart;
		char valor = nextChar();
		while (charText.contains(((char) valor)) && ((char) valor != -1)) {
			lexReturned = lexReturned+((char) valor);
			valor=nextChar();
		}
		returnChar(valor);
		return lexReturned;
	}
	
	void loadSet () {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.,;:+-*/()[]!?";
		int i=0;
		Character a = new Character('a');
		while (i < s.length()) {
			a = s.charAt(i);
			charText.add(a);
			i++;
		}
		//System.out.println(charText);
	}
	
	char nextChar() throws IOException{
		if (charBuffUsed) {
			charBuffUsed = false;
			return charBuff;
		} else {
		int valor=filereader.read();
		return ((char) valor);
		}
	}
	
	void returnChar (char r) {
		charBuffUsed = true;
		charBuff = r;
	}

	void errorLexico (String e) {
		System.out.println("Error léxico en línea "+line+" : "+e);
	}
}
