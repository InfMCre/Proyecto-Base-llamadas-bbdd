package model;

import java.util.List;

public class Department {

	private Integer deptNo;
	private String dnombre;
	private String loc;
	
	private List<Employee> listaEmpleados;
	
	
	public Department() {}
	
	public Department(Integer deptNo, String dnombre, String loc) {
		super();
		this.deptNo = deptNo;
		this.dnombre = dnombre;
		this.loc = loc;
	}
	
	public Department(Integer deptNo, String dnombre, String loc, List<Employee> listaEmpleados) {
		super();
		this.deptNo = deptNo;
		this.dnombre = dnombre;
		this.loc = loc;
		this.listaEmpleados = listaEmpleados;
	}
	
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getDnombre() {
		return dnombre;
	}
	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Employee> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(List<Employee> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", dnombre=" + dnombre + ", loc=" + loc + ", listaEmpleados="
				+ listaEmpleados + "]";
	}
	
}
