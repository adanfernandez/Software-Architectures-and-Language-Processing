package simpleCss.ast;

import java.util.List;

import simpleCss.visitor.Visitor;

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
	
	public String toString() {
		return "h1";
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
}
