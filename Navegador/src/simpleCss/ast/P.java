package simpleCss.ast;

public class P implements Campo {
	Asignacion asignacion;
	public P(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	
	public Asignacion getAsignacion() {
		return asignacion;
	}
	
	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
}
