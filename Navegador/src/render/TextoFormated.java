package render;

public class TextoFormated {
	private String contenido;
	private String color;
	private String size;
	private String style;
	
	public TextoFormated(String contenido, String color, String size, String style) {
		super();
		this.contenido = contenido;
		this.color = color;
		this.size = size;
		this.style = style;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
