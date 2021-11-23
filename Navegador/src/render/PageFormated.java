package render;

import java.util.List;

public class PageFormated {
	
	String title;
	List<LineaFormated> lineas;
	public PageFormated(String title, List<LineaFormated> lineas) {
		super();
		this.title = title;
		this.lineas = lineas;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<LineaFormated> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaFormated> lineas) {
		this.lineas = lineas;
	}
	
}
