package simpleCss.ast;

import java.util.List;

public class P implements Campo {
	List<Asignacion> asignaciones;
	
	public P(List<Asignacion> asignacion) {
		this.asignaciones = asignacion;
	}
	
	public List<Asignacion> getAsignacion() {
		return asignaciones;
	}
	
	public void setAsignacion(List<Asignacion>  asignaciones) {
		this.asignaciones = asignaciones;
	}
}
