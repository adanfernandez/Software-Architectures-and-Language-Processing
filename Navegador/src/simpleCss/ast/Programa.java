package simpleCss.ast;

import java.util.ArrayList;
import java.util.List;

public class Programa {
	List<Campo> atributos;

	public Programa(List<Campo> atributos) {
		super();
		this.atributos = atributos;
	}
	
	public Programa() {
		super();
		this.atributos = new ArrayList<Campo>();
	}

	public List<Campo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Campo> atributos) {
		this.atributos = atributos;
	}
	
	
}
