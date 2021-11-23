package simpleCss.ast;

import java.util.ArrayList;
import java.util.List;

import simpleCss.visitor.Visitor;

public class ProgramaCss implements AstCss {
	List<Campo> atributos;

	public ProgramaCss(List<Campo> atributos) {
		super();
		this.atributos = atributos;
	}
	
	public ProgramaCss() {
		super();
		this.atributos = new ArrayList<Campo>();
	}

	public List<Campo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Campo> atributos) {
		this.atributos = atributos;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	
}
