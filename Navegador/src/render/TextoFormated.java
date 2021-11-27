package render;

public class TextoFormated {
	private String contenido;
	private String color;
	private Double size;
	private String style;
	private Double width;
	
	public TextoFormated(String contenido, String color, Double size, String style, Double width) {
		super();
		this.contenido = contenido;
		this.color = color;
		this.size = size;
		this.style = style;
		this.width = width;
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

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}
	
	public double calculateMetrics() {
		if(contenido == null) {
			return 0;
		}
		return this.contenido.length() * size;
	}
}
