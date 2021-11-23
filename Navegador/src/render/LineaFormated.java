package render;

import java.util.ArrayList;
import java.util.List;

public class LineaFormated {
	
	String align;
	List<TextoFormated> textos;
	
	public LineaFormated(String align) {
		this.align = align; 
		this.textos = new ArrayList<TextoFormated>();
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public List<TextoFormated> getTextos() {
		return textos;
	}

	public void setTextos(List<TextoFormated> textos) {
		this.textos = textos;
	}
	

}
