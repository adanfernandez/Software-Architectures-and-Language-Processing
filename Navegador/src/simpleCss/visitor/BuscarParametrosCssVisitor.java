package simpleCss.visitor;

import java.util.List;

import simpleCss.ast.Asignacion;
import simpleCss.ast.AstCss;
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
import simpleCss.ast.Italic;
import simpleCss.ast.Left;
import simpleCss.ast.Negrita;
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
	public Object visit(ProgramaCss p, Object param) {
		for(Campo campo : p.getAtributos()) {
			if(campo.toString().equals(identificador)) {
				return campo.accept(this, param);
			}
		}
		return null;
	}
		
	
	

	@Override
	public Object visit(H1 p, Object param) {
		for(Asignacion asignacion : p.getAsignacion()) {
			if(asignacion.toString().equals(etiqueta)) {
				return asignacion.accept(this, param);
			}
		}
		return null;
	}

	@Override
	public Object visit(H2 p, Object param) {
		for(Asignacion asignacion : p.getAsignacion()) {
			if(asignacion.toString().equals(etiqueta)) {
				return asignacion.accept(this, param);
			}
		}
		return null;
	}
	
	@Override
	public Object visit(P p, Object param) {
		for(Asignacion asignacion : p.getAsignacion()) {
			if(asignacion.toString().equals(etiqueta)) {
				return asignacion.accept(this, param);
			}
		}
		return null;
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
		return p.getValor().accept(this, param);
	}

	@Override
	public Object visit(FontSize p, Object param) {
		return p.getValor().accept(this, param);
	}

	@Override
	public Object visit(FontStyle p, Object param) {
		return p.getValor().accept(this, param);
	}

	@Override
	public Object visit(Green p, Object param) {
		return p.toString();
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
	public Object visit(Right p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(Size p, Object param) {
		return p.toString();
	}

	@Override
	public Object visit(TextAlign p, Object param) {
		return p.getValor().accept(this, param);
	}
	
	public String buscar(String identificador, String etiqueta, AstCss astCss) {
		this.etiqueta = etiqueta;
		this.identificador = identificador;
		
		if(this.etiqueta == null || this.identificador == null)
			return null;
		return (String) astCss.accept(this, null);
	}




	@Override
	public Object visit(Negrita negrita, Object param) {
		return negrita.toString();
	}
}
