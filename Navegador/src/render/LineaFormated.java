package render;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextFormatter;

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

	public double calcularMetricas() {
		double metrica = 0.0;
		for (TextoFormated ft : this.textos) {
			if (ft != null) {
				metrica += ft.calculateMetrics();
			}
		}
		return metrica;
	}

}
