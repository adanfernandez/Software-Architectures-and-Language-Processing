package render;

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
import simpleHtml.ast.Head;
import simpleHtml.ast.Href;
import simpleHtml.ast.Link;
import simpleHtml.ast.Negrita;
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
		List<LineaFormated> lineas = (List<LineaFormated>) p.getBody().accept(this, param);
		page.setLineas(null);
		return page;
	}

	@Override
	public Object visit(Head p, Object param) {
		return p.accept(this, param);
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
	public Object visit(Texto cadena, Object param) {
		return cadena.getCadena();
	}

	@Override
	public Object visit(Body body, Object param) {
		PageFormated page = new PageFormated(null, null);
		for (Etiqueta etiqueta : body.getEtiquetas()) {
			etiqueta.accept(this, param);
		}
		return page;
	}

	@Override
	public Object visit(Title title, Object param) {
		List<Texto> textos = title.getTextos();
		String cadena = "";
		for (Texto texto : textos) {
			cadena += texto.accept(this, param);
		}
		return cadena;
	}

	@Override
	public Object visit(H1 h1, Object param) {
		String align = bcss.buscar("h2", "text-align", defaultCss);
		if (align == null)
			align = bcss.buscar("h2", "text-align", defaultCss);
		LineaFormated lineaFormated = new LineaFormated(align);
		for (Elemento elemento : h1.getElementos()) {
			String  s = "h1";
			String color = bcss.buscar(s, "color", programaCss);
			if(color == null)
				color = bcss.buscar(s, "color", defaultCss);
			String size = bcss.buscar(s, "font-size", defaultCss);
			if(size == null)
					size = bcss.buscar(s, "font-size", defaultCss);
			String style = bcss.buscar(s, "font-style", programaCss);
			if(style == null)
				style = bcss.buscar(s, "font-style", defaultCss);
			
		}

		return null;
	}

	@Override
	public Object visit(H2 h2, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(P p, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Negrita negrita, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Cursiva cursiva, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Subrayado subrayado, Object param) {
		// TODO Auto-generated method stub
		return null;
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

}
