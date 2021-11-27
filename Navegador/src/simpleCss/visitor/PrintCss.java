package simpleCss.visitor;

import simpleCss.ast.Asignacion;
import simpleCss.ast.Black;
import simpleCss.ast.Blue;
import simpleCss.ast.Campo;
import simpleCss.ast.Center;
import simpleCss.ast.Color;
import simpleCss.ast.FontSize;
import simpleCss.ast.FontStyle;
import simpleCss.ast.Green;
import simpleCss.ast.H1;
import simpleCss.ast.H2;
import simpleCss.ast.H3;
import simpleCss.ast.Italic;
import simpleCss.ast.Left;
import simpleCss.ast.Negrita;
import simpleCss.ast.Normal;
import simpleCss.ast.P;
import simpleCss.ast.ProgramaCss;
import simpleCss.ast.Right;
import simpleCss.ast.Size;
import simpleCss.ast.TextAlign;
import simpleCss.ast.Width;

public class PrintCss implements Visitor {
	
	private String sp = " ";

	@Override
	public Object visit(ProgramaCss p, Object param) {
		String cadena = "Programa\n";
		for(Campo c : p.getAtributos()) {
			cadena = cadena + (String) c.accept(this,(String)param+sp)+"\n";
		}
		return cadena;
	}
	
	@Override
	public Object visit(Black p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(Blue p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(Center p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(Color p, Object param) {
		return "Color " + p.getValor().accept(this, param);
	}

	@Override
	public Object visit(FontSize p, Object param) {
		return "FontSize " + p.getValor().accept(this, param);

	}

	@Override
	public Object visit(FontStyle p, Object param) {
		return "FontStyle" + p.getValor().accept(this, param);

	}

	@Override
	public Object visit(Green p, Object param) {
		return p.toString();

	}

	@Override
	public Object visit(H1 p, Object param) {
		String cadena = "H1\n";
		for(Asignacion c : p.getAsignacion()) {
			cadena = cadena + (String) c.accept(this,(String)param+sp)+"\n";
		}
		return cadena;
	}

	@Override
	public Object visit(H2 p, Object param) {
		String cadena = "H2\n";
		for(Asignacion c : p.getAsignacion()) {
			cadena = cadena + (String) c.accept(this,(String)param+sp)+"\n";
		}
		return cadena;
	}

	@Override
	public Object visit(Italic p, Object param) {
		return p.toString();

	}

	@Override
	public Object visit(Left p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(Normal p, Object param) {
		return p.toString();

	}

	@Override
	public Object visit(P p, Object param) {
		String cadena = "P\n";
		for(Asignacion c : p.getAsignacion()) {
			cadena = cadena + (String) c.accept(this,(String)param+sp)+"\n";
		}
		return cadena;
	}


	@Override
	public Object visit(Right p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(Size p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(TextAlign p, Object param) {
		return "TextAlign " + p.getValor().accept(this, param);
	}

	@Override
	public Object visit(Negrita p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(H3 p, Object param) {
		String cadena = "H3\n";
		for(Asignacion c : p.getAsignacion()) {
			cadena = cadena + (String) c.accept(this,(String)param+sp)+"\n";
		}
		return cadena;
	}

	@Override
	public Object visit(Width p, Object param) {
		return "Width" + p.getValor().accept(this, param);
	}

}
