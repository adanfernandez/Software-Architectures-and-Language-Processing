package simpleCss.ast;

import java.util.List;

import simpleCss.visitor.Visitor;

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
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	@Override
	public String toString() {
		return "p";
	}
}
