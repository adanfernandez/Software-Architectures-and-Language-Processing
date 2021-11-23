package simpleCss.visitor;

import simpleCss.ast.AstCss;
import simpleCss.ast.Black;
import simpleCss.ast.Blue;
import simpleCss.ast.Center;
import simpleCss.ast.Color;
import simpleCss.ast.FontSize;
import simpleCss.ast.FontStyle;
import simpleCss.ast.Green;
import simpleCss.ast.H1;
import simpleCss.ast.H2;
import simpleCss.ast.Italic;
import simpleCss.ast.Left;
import simpleCss.ast.Normal;
import simpleCss.ast.P;
import simpleCss.ast.ProgramaCss;
import simpleCss.ast.Right;
import simpleCss.ast.Size;
import simpleCss.ast.TextAlign;

public class BuscarParametrosCssVisitor implements Visitor {

	private String etiqueta;
	private String identificador;

	@Override
	public Object visit(Black p, Object param) {
		return null;
	}

	@Override
	public Object visit(Blue p, Object param) {
		return null; 
	}

	@Override
	public Object visit(Center p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Color p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FontSize p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FontStyle p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Green p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(H1 p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(H2 p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Italic p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Left p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Normal p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(P p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProgramaCss p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Right p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Size p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(TextAlign p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String buscar(String identificador, String etiqueta, AstCss astCss) {
		this.etiqueta = etiqueta;
		this.identificador = identificador;
		
		if(this.etiqueta == null || this.identificador == null)
			return null;
		return (String) astCss.accept(this, null);
	}
}
