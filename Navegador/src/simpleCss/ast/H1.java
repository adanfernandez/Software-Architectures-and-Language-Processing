package simpleCss.ast;

import java.util.List;

public class H1 implements Campo {
	List<Asignacion> asignaciones;
	
	public H1(List<Asignacion> asignacion) {
		this.asignaciones = asignacion;
	}
	
	public List<Asignacion> getAsignacion() {
		return asignaciones;
	}
	
	public void setAsignacion(List<Asignacion>  asignaciones) {
		this.asignaciones = asignaciones;
	}
}
