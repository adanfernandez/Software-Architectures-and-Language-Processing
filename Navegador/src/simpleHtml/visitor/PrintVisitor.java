package simpleHtml.visitor;

import simpleHtml.ast.Body;
import simpleHtml.ast.Cadena;
import simpleHtml.ast.Cursiva;
import simpleHtml.ast.Elemento;
import simpleHtml.ast.Etiqueta;
import simpleHtml.ast.H1;
import simpleHtml.ast.H2;
import simpleHtml.ast.H3;
import simpleHtml.ast.Head;
import simpleHtml.ast.Href;
import simpleHtml.ast.Link;
import simpleHtml.ast.Negrita;
import simpleHtml.ast.ContenidoTexto;
import simpleHtml.ast.P;
import simpleHtml.ast.Programa;
import simpleHtml.ast.Rel;
import simpleHtml.ast.Subrayado;
import simpleHtml.ast.Texto;
import simpleHtml.ast.Title;
import simpleHtml.ast.Type;

public class PrintVisitor implements Visitor {

	private String sp = " ";
	
	@Override
	public Object visit(Programa p, Object param) {
		String head = (String) p.getHead().accept(this, sp);
		String body = (String) p.getBody().accept(this, sp);
		String cadena = String.format("Programa\n%s\n%s\n", head, body);
		return cadena;
	}

	@Override
	public Object visit(Head p, Object param) {
		String title = (String) p.getTitle().accept(this, sp);
		String link = (String) p.getLink().accept(this, sp);
		String cadena = String.format("Head\n%s\n%s\n", title, link);
		return cadena;
	}

	@Override
	public Object visit(Link p, Object param) {
		String href = (String) p.getHref().accept(this, sp);
		String rel = (String) p.getRel().accept(this, sp);
		String type = (String) p.getType().accept(this, sp);
		String cadena = String.format("Link\n%s\n%s\n%s\n", href, rel, type);
		return cadena;
	}

	@Override
	public Object visit(Href p, Object param) {
		String cadena = (String) p.getCadena().accept(this, sp);
		String cadenar = String.format("Href\n%s\n", cadena);
		return cadenar;
	}

	@Override
	public Object visit(Rel p, Object param) {
		String cadena = (String) p.getCadena().accept(this, sp);
		String cadenar = String.format("Rel\n%s\n", cadena);
		return cadenar;
	}

	@Override
	public Object visit(Type type, Object param) {
		String cadena = (String) type.getCadena().accept(this, sp);
		String cadenar = String.format("Type\n%s\n", cadena);
		return cadenar;
	}

	@Override
	public Object visit(Cadena cadena, Object param) {
		return String.format("Cadena: %s\n", cadena.getCadena());
	}


	@Override
	public Object visit(Body body, Object param) {
		String cadena = "Body\n";
		for (Etiqueta p : body.getEtiquetas())
			cadena = cadena + (String) p.accept(this,(String)param+sp)+"\n";
		return cadena;
	}

	@Override
	public Object visit(Title title, Object param) {
		String s = (String)param+"Title\n";
		for(ContenidoTexto texto : title.getTextos()) {
			s += texto.accept(this, (String)param+sp);
		}
		return s;
	}

	@Override
	public Object visit(H1 h1, Object param) {
		String s= (String) param + "H1\n";
		for (Elemento h : h1.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}

	@Override
	public Object visit(H2 h2, Object param) {
		String s= (String) param + "H2\n";
		for (Elemento h : h2.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}
	
	@Override
	public Object visit(H3 h3, Object param) {
		String s= (String) param + "H3\n";
		for (Elemento h : h3.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}

	@Override
	public Object visit(P p, Object param) {
		String s= (String) param + "P\n";
		for (Elemento h : p.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}
	
	
	@Override
	public Object visit(Texto texto, Object param) {
		String s= (String) param + "Texto\n";
		for (ContenidoTexto h : texto.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}

	@Override
	public Object visit(Negrita negrita, Object param) {
		String s= (String) param + "Negrita\n";
		for (ContenidoTexto h : negrita.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}

	@Override
	public Object visit(Cursiva cursiva, Object param) {
		String s= (String) param + "Cursiva\n";
		for (ContenidoTexto h : cursiva.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}

	@Override
	public Object visit(Subrayado subrayado, Object param) {
		String s= (String) param + "Subrayado\n";
		for (ContenidoTexto h : subrayado.getElementos())
			s = s + (String) h.accept(this,(String)param+sp)+"\n";
		return s;
	}

	@Override
	public Object visit(ContenidoTexto normal, Object param) {
		return String.format("\tNormal: %s\n", normal.getCadena());
	}
}
