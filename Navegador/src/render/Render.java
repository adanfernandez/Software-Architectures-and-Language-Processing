package render;

import java.util.ArrayList;
import java.util.List;

import simpleCss.ast.ProgramaCss;
import simpleCss.visitor.BuscarParametrosCssVisitor;
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
import simpleHtml.ast.Normal;
import simpleHtml.ast.P;
import simpleHtml.ast.Programa;
import simpleHtml.ast.Rel;
import simpleHtml.ast.Subrayado;
import simpleHtml.ast.Texto;
import simpleHtml.ast.Title;
import simpleHtml.ast.Type;
import simpleHtml.visitor.Visitor;

public class Render implements Visitor {

	BuscarParametrosCssVisitor bcss;
	ProgramaCss programaCss;
	ProgramaCss defaultCss;

	public Render(BuscarParametrosCssVisitor bcss, ProgramaCss programaCss, ProgramaCss defaultCss) {
		this.bcss = bcss;
		this.programaCss = programaCss;
		this.defaultCss = defaultCss;
	}

	@Override
	public Object visit(Programa p, Object param) {
		String title = (String) p.getHead().accept(this, param);
		PageFormated page = (PageFormated) p.getBody().accept(this, param);
		page.setTitle(title);
		return page;
	}

	@Override
	public Object visit(Head p, Object param) {
		return p.getTitle().accept(this, param);
	}

	@Override
	public Object visit(Link p, Object param) {
		return null;
	}

	@Override
	public Object visit(Href p, Object param) {
		return null;
	}

	@Override
	public Object visit(Rel p, Object param) {
		return null;
	}

	@Override
	public Object visit(Type type, Object param) {
		return null;
	}

	@Override
	public Object visit(Cadena cadena, Object param) {
		return cadena.getCadena();
	}


	@Override
	public Object visit(Body body, Object param) {
		PageFormated page = new PageFormated(null, new ArrayList<LineaFormated>());
		for (Etiqueta etiqueta : body.getEtiquetas()) {
			page.getLineas().add((LineaFormated) etiqueta.accept(this, param));
		}
		return page;
	}

	@Override
	public Object visit(Title title, Object param) {
		List<Normal> textos = title.getTextos();
		String cadena = "";
		for (Normal texto : textos) {
			cadena += " " + texto.accept(this, param);
		}
		return cadena;
	}

	@Override
	public Object visit(H1 h1, Object param) {
		String align = bcss.buscar("h1", "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar("h1", "text-align", defaultCss);
		LineaFormated lineaFormated = new LineaFormated(align);
		for(Elemento elemento : h1.getElementos()) {
			lineaFormated.getTextos().addAll((List<TextoFormated>)elemento.accept(this, "h1"));
		}
		return lineaFormated;
	}

	@Override
	public Object visit(H2 h2, Object param) {
		String align = bcss.buscar("h2", "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar("h2", "text-align", defaultCss);
		LineaFormated lineaFormated = new LineaFormated(align);
		for(Elemento elemento : h2.getElementos()) {
			lineaFormated.getTextos().addAll((List<TextoFormated>)elemento.accept(this, "h2"));
		}
		return lineaFormated;
	}
	
	@Override
	public Object visit(H3 h3, Object param) {
		String align = bcss.buscar("h3", "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar("h3", "text-align", defaultCss);
		LineaFormated lineaFormated = new LineaFormated(align);
		for(Elemento elemento : h3.getElementos()) {
			lineaFormated.getTextos().addAll((List<TextoFormated>)elemento.accept(this, "h3"));
		}
		return lineaFormated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object visit(P p, Object param) {
		String align = bcss.buscar("p", "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar("p", "text-align", defaultCss);
		LineaFormated lineaFormated = new LineaFormated(align);
		for(Elemento elemento : p.getElementos()) {
			lineaFormated.getTextos().addAll((List<TextoFormated>)elemento.accept(this, "p"));
		}
		return lineaFormated;
	}

	@Override
	public Object visit(Negrita negrita, Object param) {
		String s = (String) param;
		String align = bcss.buscar(s, "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar(s, "text-align", defaultCss);
		String color = bcss.buscar(s, "color", programaCss);
		if(color == null)
			color = bcss.buscar(s, "color", defaultCss);
		String size = bcss.buscar(s, "font-size", defaultCss);
		if(size == null)
				size = bcss.buscar(s, "font-size", defaultCss);
		String width = bcss.buscar(s, "width", defaultCss);
		if(width == null)
			width = bcss.buscar(s, "width", defaultCss);
		String style = "bold";
		List<TextoFormated> textos = new ArrayList<TextoFormated>();
		for(Normal elemento : negrita.getElementos()) {
			textos.add(new TextoFormated((String) elemento.accept(this, null), color, Double.parseDouble(size.replace("px", "")), style, Double.parseDouble(width.replace("%", ""))));
		}
		return textos;
	}

	@Override
	public Object visit(Cursiva cursiva, Object param) {
		String s = (String) param;
		String align = bcss.buscar(s, "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar(s, "text-align", defaultCss);
		String color = bcss.buscar(s, "color", programaCss);
		if(color == null)
			color = bcss.buscar(s, "color", defaultCss);
		String size = bcss.buscar(s, "font-size", defaultCss);
		if(size == null)
				size = bcss.buscar(s, "font-size", defaultCss);
		String width = bcss.buscar(s, "width", defaultCss);
		if(width == null)
			width = bcss.buscar(s, "width", defaultCss);
		String style = "italic";
		List<TextoFormated> textos = new ArrayList<TextoFormated>();
		for(Normal elemento : cursiva.getElementos()) {
			textos.add(new TextoFormated((String) elemento.accept(this, null), color, Double.parseDouble(size.replace("px", "")), style, Double.parseDouble(width.replace("%", ""))));
		}
		return textos;
	}

	@Override
	public Object visit(Subrayado subrayado, Object param) {
		String s = (String) param;
		String align = bcss.buscar(s, "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar(s, "text-align", defaultCss);
		String color = bcss.buscar(s, "color", programaCss);
		if(color == null)
			color = bcss.buscar(s, "color", defaultCss);
		String size = bcss.buscar(s, "font-size", defaultCss);
		if(size == null)
				size = bcss.buscar(s, "font-size", defaultCss);
		String width = bcss.buscar(s, "width", defaultCss);
		if(width == null)
			width = bcss.buscar(s, "width", defaultCss);
		String style = "underline";
		List<TextoFormated> textos = new ArrayList<TextoFormated>();
		for(Normal elemento : subrayado.getElementos()) {
			textos.add(new TextoFormated((String) elemento.accept(this, null), color, Double.parseDouble(size.replace("px", "")), style, Double.parseDouble(width.replace("%", ""))));
		}
		return textos;
	}
	

	@Override
	public Object visit(Texto cadena, Object param) {
		String s = (String) param;
		String color = bcss.buscar(s, "color", programaCss);
		String align = bcss.buscar(s, "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar(s, "text-align", defaultCss);
		if(color == null)
			color = bcss.buscar(s, "color", defaultCss);
		String size = bcss.buscar(s, "font-size", defaultCss);
		if(size == null)
				size = bcss.buscar(s, "font-size", defaultCss);
		String width = bcss.buscar(s, "width", defaultCss);
		if(width == null)
			width = bcss.buscar(s, "width", defaultCss);
		String style = "normal";
		List<TextoFormated> textos = new ArrayList<TextoFormated>();
		for(Normal elemento : cadena.getElementos()) {
			textos.add(new TextoFormated((String) elemento.accept(this, null), color, Double.parseDouble(size.replace("px", "")), style, Double.parseDouble(width.replace("%", ""))));
		}
		return textos;
	}

	public BuscarParametrosCssVisitor getBcss() {
		return bcss;
	}

	public void setBcss(BuscarParametrosCssVisitor bcss) {
		this.bcss = bcss;
	}

	public ProgramaCss getProgramaCss() {
		return programaCss;
	}

	public void setProgramaCss(ProgramaCss programaCss) {
		this.programaCss = programaCss;
	}

	public ProgramaCss getDefaultCss() {
		return defaultCss;
	}

	public void setDefaultCss(ProgramaCss defaultCss) {
		this.defaultCss = defaultCss;
	}

	@Override
	public Object visit(Normal normal, Object param) {
		return normal.getCadena();
	}

}
