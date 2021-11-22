package simpleCss.ast;

public class H1 implements Campo {
	Asignacion asignacion;
	
	public H1(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	
	public Asignacion getAsignacion() {
		return asignacion;
	}
	
	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
}
