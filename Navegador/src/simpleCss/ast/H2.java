package simpleCss.ast;

public class H2 implements Campo {
	Asignacion asignacion;
	public H2(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	
	public Asignacion getAsignacion() {
		return asignacion;
	}
	
	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
}
