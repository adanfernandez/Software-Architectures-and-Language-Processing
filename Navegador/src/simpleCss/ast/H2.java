package simpleCss.ast;

import java.util.List;

public class H2 implements Campo {
	List<Asignacion> asignaciones;
	
	public H2(List<Asignacion> asignacion) {
		this.asignaciones = asignacion;
	}
	
	public List<Asignacion> getAsignacion() {
		return asignaciones;
	}
	
	public void setAsignacion(List<Asignacion>  asignaciones) {
		this.asignaciones = asignaciones;
	}
}
